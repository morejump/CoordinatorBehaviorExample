package saulmm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
//
public class MainActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private  LinearLayout ListFriend;
    private GradientDrawable gradientDrawable;
    private TabLayout tabLayout ;
    private ViewPager viewPager;

    //
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle, mPremium;
    private ImageView mFlag;

    private ImageView mAvatar;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private PopupMenu popup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindActivity();
        creatFriends();

        mAppBarLayout.addOnOffsetChangedListener(this);

        //mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setBackgroundColor(Color.WHITE);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        //
        mAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.show();

            }
        });
    }



    private void bindActivity() {
        //
        ListFriend= (LinearLayout) findViewById(R.id.linearFriends);
        //
        gradientDrawable = new GradientDrawable();
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        //
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter= new PagerAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) );
        tabLayout.setTabsFromPagerAdapter(adapter);
        //
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mPremium= (TextView) findViewById(R.id.txtPremium);
        mTitle = (TextView) findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.main_appbar);
        mAvatar = (ImageView) findViewById(R.id.avatar);
        mFlag = (ImageView) findViewById(R.id.flag_country);

        popup = new PopupMenu(MainActivity.this, mAvatar);
        gradientDrawable.setCornerRadius(1000);
        gradientDrawable.setColor(Color.parseColor("#FEAB35"));
        mPremium.setBackground(gradientDrawable);
        //Inflating the Popup using xml file
        popup.getMenuInflater()
                .inflate(R.menu.popup_menu, popup.getMenu());
        // misss
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getOrder() == 0) {
                    // showing a picture here
                    FragmentManager fm = getSupportFragmentManager();
                    FullscreenDialog fullscreenDialog = new FullscreenDialog(mAvatar.getDrawable());
                    fullscreenDialog.show(fm, "my fragment");
                    //
                    Toast.makeText(MainActivity.this, "showing a dialog", Toast.LENGTH_SHORT).show();
                } else {

                    // showing a dialog later
                    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        mFlag.setTag("flag");
        mAvatar.setTag("avatar");

    }
    private  void creatFriends(){
        int scale = (int)ListFriend.getContext().getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(scale*32, scale*32);
        params.gravity= Gravity.CENTER;
        ImageView imageView= new ImageView(this);
        imageView.setImageResource(R.drawable.usa_flag);
        imageView.setLayoutParams(params);
        ListFriend.addView(imageView);


        for (int i=0;i<5;i++){

            LinearLayout.LayoutParams params01= new LinearLayout.LayoutParams(scale*32, scale*32);
            params01.gravity= Gravity.CENTER;
            params01.leftMargin=scale*8;
            ImageView imageView01= new ImageView(this);
            imageView01.setImageResource(R.drawable.usa_flag);
            imageView01.setLayoutParams(params01);
            ListFriend.addView(imageView01);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mToolbar.setBackgroundColor(Color.parseColor("#37A8F4"));
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mToolbar.setBackgroundColor(Color.WHITE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {

        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1.0f)
                : new AlphaAnimation(1.0f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
