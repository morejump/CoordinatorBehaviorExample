package saulmm.myapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GiveFeedbackAnswer extends AppCompatActivity implements TextWatcher  {
    private EditText edtAnswer;
    private  int Start;
    private Toolbar toolbar;
    private  int len;
    private ImageView btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback_answer);
        init();
    }

    private void init() {
        edtAnswer = (EditText) findViewById(R.id.edtAnswer);
        edtAnswer.addTextChangedListener(this);
        btnSend= (ImageView) findViewById(R.id.imgSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Dialog dialog = new Dialog(view.getContext());
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_send);
                dialog.show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int i1, int i2) {
        len= charSequence.length();
        Start = start;

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable)
    {
        if (Start+1<= editable.length() && len<=editable.length() )
        editable.setSpan(new ForegroundColorSpan(Color.parseColor("#00D800")), Start, Start+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

    }

}
