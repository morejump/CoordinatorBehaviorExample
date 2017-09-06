package saulmm.myapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ContactUs extends AppCompatActivity {
    GradientDrawable shape;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        shape= new GradientDrawable();
        shape.setColor(Color.parseColor("#38A8F5"));
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(1000);
        btnSend= (Button) findViewById(R.id.btnSend);
        btnSend.setBackground(shape);

    }
}
