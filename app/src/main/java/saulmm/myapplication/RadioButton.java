package saulmm.myapplication;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.dinuscxj.progressbar.CircleProgressBar;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;


public class RadioButton extends AppCompatActivity {
    GradientDrawable TrashDrawable, BackgroundDrawable;
    ScaleAnimation anim_zoom_in, anim_zoom_out;
    int progress;
    boolean isRecorded;
    boolean isInProgress;
    boolean isLongClicked;
    FrameLayout mFrame;
    CircleProgressBar CirleProgressbar;
    ImageView imgMic, imgTrash, imgBackground;
    ValueAnimator AnimationProgressbar;
    RotateAnimation animRotateLongClick, animRotateClick, animRotateChangePicture, animRotatePlayButton;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isRecorded && isInProgress == false) {
                // do stuff when finishing record an audio
                isInProgress = true;
                SetProgressColor("#3BA7F5");
                AnimationProgressbar.addUpdateListener(UpdateUIProgressClick);
                AnimationProgressbar.start();
                imgMic.startAnimation(animRotateClick);
                Toast.makeText(RadioButton.this, "Recorded", Toast.LENGTH_SHORT).show();
            } else if (isRecorded && isInProgress == true) {
                AnimationProgressbar.cancel();
                SetProgressColor("#FFFFFF");
                imgMic.startAnimation(animRotateChangePicture);
                isInProgress = false;

            } else {
                Toast.makeText(RadioButton.this, "Showing a toast", Toast.LENGTH_SHORT).show();
                new SimpleTooltip.Builder(view.getContext())
                        .anchorView(view)
                        .text("Texto do Tooltip")
                        .gravity(Gravity.END)
                        .animated(true)
                        .transparentOverlay(false)
                        .build()
                        .show();
            }

        }
    };

    // catching an event long click
    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            AnimationProgressbar.addUpdateListener(UpdateUIProgressLongClick);
            isLongClicked = true;
            if (isRecorded == false) {
                BackgroundDrawable.setColor(Color.parseColor("#F1C7CA"));
                imgBackground.startAnimation(anim_zoom_in);
                imgMic.setImageResource(R.drawable.ic_red_mic);
                SetProgressColor("#FF0000");
                AnimationProgressbar.start();

            }

            return true;
        }
    };

    // catching a event when action up
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_UP && isLongClicked == true && isRecorded == false) {
                BackgroundDrawable.setColor(Color.TRANSPARENT);
                //

                imgBackground.clearAnimation();
                imgBackground.setAnimation(null);
                anim_zoom_in.cancel();
                anim_zoom_out.cancel();
                //

                imgTrash.setVisibility(View.VISIBLE);
                imgTrash.animate().translationX(250).setDuration(500).start();
                imgMic.setImageResource(R.drawable.ic_blue_mic);
                imgMic.setImageResource(R.drawable.ic_blue_play_button);
                imgMic.startAnimation(animRotateLongClick);
                AnimationProgressbar.end();
                isLongClicked = false;
                isRecorded = true;
            }

            return false;
        }
    };

    //  update progress here
    ValueAnimator.AnimatorUpdateListener UpdateUIProgressLongClick = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int progress = (int) valueAnimator.getAnimatedValue();
            CirleProgressbar.setProgress(progress);
            if (progress == 100) {
                SetProgressColor("#FFFFFF");

            }

        }
    };
    ValueAnimator.AnimatorUpdateListener UpdateUIProgressClick = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            progress = (int) valueAnimator.getAnimatedValue();
            CirleProgressbar.setProgress(progress);
            if (progress == 100) {
                SetProgressColor("#FFFFFF");
                isInProgress = false;
                imgMic.startAnimation(animRotateChangePicture);
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        init();

    }

    private void SetProgressColor(String color) {
        CirleProgressbar.setProgressStartColor(Color.parseColor(color));
        CirleProgressbar.setProgressEndColor(Color.parseColor(color));
    }

    private void init() {
        //
        anim_zoom_in = new ScaleAnimation(1f, 1.5f, 1f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim_zoom_in.setFillAfter(true);
        anim_zoom_in.setDuration(600);
        anim_zoom_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgBackground.startAnimation(anim_zoom_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //
        anim_zoom_out = new ScaleAnimation(1.5f, 1f, 1.5f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim_zoom_out.setFillAfter(true);
        anim_zoom_out.setDuration(600);
        anim_zoom_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgBackground.startAnimation(anim_zoom_in);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //
        BackgroundDrawable = new GradientDrawable();
        BackgroundDrawable.setShape(GradientDrawable.RECTANGLE);
        BackgroundDrawable.setColor(Color.parseColor("#F1C7CA"));
        BackgroundDrawable.setCornerRadius(1000);
        //
        TrashDrawable = new GradientDrawable();
        TrashDrawable.setShape(GradientDrawable.RECTANGLE);
        TrashDrawable.setColor(Color.parseColor("#FFFFFF"));
        TrashDrawable.setCornerRadius(1000);
        //

        isInProgress = false;
        isRecorded = false;
        isLongClicked = false;
        //
        imgTrash = (ImageView) findViewById(R.id.ic_red_trash_button);
        //
        animRotateLongClick = new RotateAnimation(0.0f, 360.0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotateLongClick.setDuration(500);
        animRotateLongClick.setFillAfter(true);
        //
        animRotatePlayButton = new RotateAnimation(0f, 360.0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotatePlayButton.setDuration(600);
        animRotatePlayButton.setInterpolator(new LinearInterpolator());
        animRotatePlayButton.setFillAfter(false);
        //
        animRotateClick = new RotateAnimation(0.0f, 360.0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotateClick.setDuration(500);
        animRotateClick.setFillAfter(true);
        animRotateClick.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgMic.setImageResource(R.drawable.ic_blue_pause_button);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //
        animRotateChangePicture = new RotateAnimation(0.0f, 360.0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotateChangePicture.setDuration(500);
        animRotateChangePicture.setFillAfter(true);
        animRotateChangePicture.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgMic.setImageResource(R.drawable.ic_blue_play_button);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // restoring  a sate of button here
                isRecorded = false;
                isInProgress = false;
                isLongClicked = false;
                imgTrash.setVisibility(View.INVISIBLE);
                imgTrash.animate().translationX(0).start();
                imgMic.setImageResource(R.drawable.ic_blue_mic);
                imgMic.startAnimation(animRotatePlayButton);
                AnimationProgressbar.cancel();
                SetProgressColor("#FFFFFF");


            }
        });

        //
        imgBackground = (ImageView) findViewById(R.id.imgBackground);
        imgBackground.setBackground(BackgroundDrawable);

        mFrame = (FrameLayout) findViewById(R.id.mFame);
        mFrame.bringToFront();
        imgMic = (ImageView) findViewById(R.id.imgMic);
        imgTrash = (ImageView) findViewById(R.id.ic_red_trash_button);
        imgTrash.setBackground(TrashDrawable);
        imgTrash.setVisibility(View.INVISIBLE);
        CirleProgressbar = (CircleProgressBar) findViewById(R.id.line_progress);
        CirleProgressbar.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        SetProgressColor("#FF0000");
        CirleProgressbar.setOnClickListener(onClickListener);
        CirleProgressbar.setOnLongClickListener(onLongClickListener);
        CirleProgressbar.setOnTouchListener(onTouchListener);
        //
        AnimationProgressbar = ValueAnimator.ofInt(0, 100);
        AnimationProgressbar.addUpdateListener(UpdateUIProgressLongClick);
        AnimationProgressbar.setRepeatCount(0);
        AnimationProgressbar.setDuration(7000);
    }


}
