package saulmm.myapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

import saulmm.myapplication.Adapters.AdapterCorrection;
import saulmm.myapplication.Models.CorrectionModel;

public class MyCorrection extends AppCompatActivity {
    GradientDrawable drawable;
    ImageView imgAvatar, imgFlag;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_corection);
        bindViews();

    }
    private  void bindViews(){
        drawable= new GradientDrawable();
        drawable.setCornerRadius(1000);
        drawable.setColor(Color.parseColor("#F01E1E"));
        drawable.setShape(GradientDrawable.RECTANGLE);
        //
        imgAvatar = new ImageView(this);
        imgAvatar.setBackground(drawable);
        imgAvatar.setImageResource(R.drawable.sea);
        //
        imgFlag = new ImageView(this);
        imgFlag.setImageResource(R.drawable.sea);
        //
        recyclerView = (RecyclerView) findViewById(R.id.recycleCorrection);
        ArrayList<CorrectionModel> CorrectionModels = new ArrayList<CorrectionModel>();
        for (int i=0; i<10;i++){
            CorrectionModels.add(new CorrectionModel(imgAvatar, imgFlag,"Karina", "vietnam","vi thao dep trai","Monday, 10 Apr 2017 09:53",1, 69));
        }
        AdapterCorrection adapterCorrection = new AdapterCorrection(CorrectionModels);
        recyclerView.setAdapter(adapterCorrection);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
