package saulmm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



import java.util.Date;

public class TestActivity extends AppCompatActivity {

    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init();
    }
    private void init(){
        txtDisplay= (TextView) findViewById(R.id.txtDisplay);

    }
    private  class  MyFormat  {


    }
}
