package saulmm.myapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;

public class itemOnListCorrection extends AppCompatActivity {
    GradientDrawable drawable;
    ImageView imgAvatar;
   // RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_exercise);
        bindViews();
    }
    private  void bindViews(){
        Log.d("inside     ", "bindViews: ");
        imgAvatar= (ImageView) findViewById(R.id.imgAvatar);
        drawable= new GradientDrawable();
        drawable.setCornerRadius(1000);
        drawable.setColor(Color.parseColor("#F01E1E"));
        drawable.setShape(GradientDrawable.RECTANGLE);
        imgAvatar.setBackground(drawable);
        imgAvatar.setImageResource(R.drawable.ic_account);

    }
}
