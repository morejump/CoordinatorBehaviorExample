package saulmm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Voucher extends AppCompatActivity {
    Button btnclick;
    VoucherDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        init();

    }
    private  void init(){
        dialog= new VoucherDialog(this);
        btnclick= (Button) findViewById(R.id.btnClick);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

            }
        });


    }
}
