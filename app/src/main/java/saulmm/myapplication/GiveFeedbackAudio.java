package saulmm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import saulmm.myapplication.Utils.Circle;
import saulmm.myapplication.Utils.CircleAngleAnimation;

public class GiveFeedbackAudio extends AppCompatActivity implements View.OnTouchListener, Animation.AnimationListener {
    FrameLayout frmContainer;
    ImageView imgCircleImage, imgMic, imgTrash;
    Circle circle;
    CircleAngleAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback_audio);
        //
       // imgMic= (ImageView) findViewById(R.id.txtHint);
        //imgTrash= (ImageView) findViewById(R.id.imgTrash);
        //frmContainer= (FrameLayout) findViewById(R.id.frmContainer);
       /// imgCircleImage= (ImageView) findViewById(R.id .imgCircleImage);
       // circle = (Circle) findViewById(R.id.circle);
//        Glide.with(this).load(R.TrashDrawable.ic_white_background).apply(RequestOptions.circleCropTransform()).into(imgCircleImage);
//
//        animation = new CircleAngleAnimation(circle,360);
//        animation.setDuration(5000);
//        imgCircleImage.setOnTouchListener(this);
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction()== MotionEvent.ACTION_DOWN){
//            imgMic.setImageResource(R.TrashDrawable.ic_red_mic);
//            circle.setRect(imgCircleImage);
//            circle.startAnimation(animation);

        }


        if (motionEvent.getAction()== MotionEvent.ACTION_UP){
//            circle.clearAnimation();
//            circle.setVisibility(View.INVISIBLE);
//            imgMic.setImageResource(R.TrashDrawable.ic_blue_mic);
//            imgMic.setImageResource(R.TrashDrawable.ic_play_button);
//
//            //RotateAnimation TranslationX = new RotateAnimation(0f, 350f, 15f, 15f);
//            RotateAnimation TranslationX = new RotateAnimation(180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//            TranslationX.setAnimationListener(this);
//            TranslationX.setInterpolator(new LinearInterpolator());
//            //TranslationX.setRepeatCount(Animation.INFINITE);
//            TranslationX.setDuration(350);
//            imgMic.startAnimation(TranslationX);

        }
        return true;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.d("thaohandsome", "onAnimationEnd: ");
        //imgTrash.setVisibility(View.VISIBLE);
        //imgTrash.setTranslationX(300);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
