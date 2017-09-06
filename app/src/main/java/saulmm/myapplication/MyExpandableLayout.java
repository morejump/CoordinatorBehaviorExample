package saulmm.myapplication;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import org.w3c.dom.Text;

/**
 * Created by morejump on 31/07/2017.
 */
//
public class MyExpandableLayout extends RelativeLayout {
    public SparseBooleanArray expandState = new SparseBooleanArray();

    public String Title;
    public String Detail;
    RelativeLayout buttonLayout,relativelayout;
    TextView txtdescription, txtTitle;
    ExpandableLinearLayout expandableLayout;

    public MyExpandableLayout(Context context) {
        super(context);

    }

    public MyExpandableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyExpandableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public MyExpandableLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void Init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_view_list_row, null);
        removeAllViews();
        relativelayout = (RelativeLayout) view.findViewById(R.id.relativelayout);
        buttonLayout = (RelativeLayout) view.findViewById(R.id.button);
        expandableLayout = (ExpandableLinearLayout) view.findViewById(R.id.expandableLayout);
        txtdescription = (TextView) view.findViewById(R.id.txtdescription);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setText(Title);
        txtdescription.setText(Detail);
        relativelayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableLayout.toggle();
            }
        });
        expandableLayout.setInRecyclerView(true);
        expandableLayout.setInterpolator( Utils.createInterpolator(Utils.ACCELERATE_DECELERATE_INTERPOLATOR));
        expandableLayout.setExpanded(expandState.get(0));
        expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(buttonLayout, 0f, 180f).start();
                expandState.put(0, true);
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(buttonLayout, 180f, 0f).start();
                expandState.put(0, false);
            }
        });
        buttonLayout.setRotation(expandState.get(0) ? 180f : 0f);
        this.addView(view);
    }
    //
    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(100);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

}
