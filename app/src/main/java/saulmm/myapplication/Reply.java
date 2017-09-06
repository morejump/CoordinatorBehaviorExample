package saulmm.myapplication;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.nhaarman.supertooltips.ToolTip;
import com.nhaarman.supertooltips.ToolTipRelativeLayout;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class Reply extends AppCompatActivity {
    private boolean isTouch=false;
    int progress = 0;
    private TextView txtSwipe;
    private Button btnClick;
    private ImageView imgBack;
    ProgressBar progressBar, circleProgressbar;
    boolean IsSend = false;
    EditText edtMessage;
    FloatingActionButton btnSend;
    private boolean SendButtonLongPressed = false;
    Thread mThread;

    private View.OnLongClickListener btnSendHoldListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View pView) {

            if (IsSend == false) {
                txtSwipe.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                if (mThread == null) {
                    mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                progressBar.setProgress(progress);// why??
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progress += 1;
                                if (progress == 100) {
                                    // hiding the progressbar and
                                    // hideViews();
                                    break;
                                }
                            }
                            progress = 0;

                        }
                    });
                    mThread.start();
                }

            }
            SendButtonLongPressed = true;
            return true;
        }
    };
    //

    private View.OnTouchListener btnSendTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View pView, MotionEvent pEvent) {
            int THRESHOLD = 30;
            int initX = 0;
            int initY = 0;
            int initXtxt = 0;
            int initYtxt = 0;
            pView.onTouchEvent(pEvent);
            if (pEvent.getAction() == MotionEvent.ACTION_UP) {
                if (SendButtonLongPressed && isTouch==false) {
                    // Do something when the button is released.
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pView.getWindowToken(), 0);
                    btnSend.setVisibility(View.GONE);
                    circleProgressbar.setVisibility(View.VISIBLE);
                    //
                    txtSwipe.setX(initXtxt);
                    txtSwipe.setY(initXtxt);
                    txtSwipe.setVisibility(View.GONE);
                    progressBar.setVisibility(View.INVISIBLE);
                    progress = 0;
                    SendButtonLongPressed = false;
                }
                else if (SendButtonLongPressed && isTouch==true){
                    txtSwipe.setX(initXtxt);
                    txtSwipe.setY(initXtxt);
                    txtSwipe.setVisibility(View.GONE);
                    progressBar.setVisibility(View.INVISIBLE);
                    progress = 0;
                    SendButtonLongPressed = false;
                }
            } else if (pEvent.getAction() == MotionEvent.ACTION_MOVE) {

                if (((int) pEvent.getX() - initX) < -THRESHOLD) {
                    isTouch= true;
                    int a = (int) pEvent.getX() - initX;
                    txtSwipe.setTranslationX(initXtxt + a);
                    if (a < -150) {
                        txtSwipe.setVisibility(View.GONE);
                        progressBar.setVisibility(View.INVISIBLE);
                        progress = 0;

                    }
                }
            } else if (pEvent.getAction() == MotionEvent.ACTION_DOWN) {
                // Toast.makeText(Reply.this, "down", Toast.LENGTH_SHORT).show();
                initXtxt = (int) txtSwipe.getX();
                initYtxt = (int) txtSwipe.getY();
                //
                initX = (int) pEvent.getX();
                initY = (int) pEvent.getY();
            }
            return false;
        }
    };

    private void hideViews() {
        progressBar.setVisibility(View.INVISIBLE);
        txtSwipe.setVisibility(View.INVISIBLE);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        btnClick = (Button) findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }

    void showDialog() {

        final Dialog dialog = new Dialog(this, R.style.Theme_AppCompat);
        dialog.setContentView(R.layout.activity_reply);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        txtSwipe = (TextView) dialog.findViewById(R.id.txtSwipe);
        String str = "< swipe to cancle";
        txtSwipe.setText(Html.fromHtml(str));
        circleProgressbar = (ProgressBar) dialog.findViewById(R.id.circleProgressbar);
        circleProgressbar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#33AAFA"), android.graphics.PorterDuff.Mode.MULTIPLY);


        imgBack = (ImageView) dialog.findViewById(R.id.imgBack);
        edtMessage = (EditText) dialog.findViewById(R.id.edtMessage);
        btnSend = (FloatingActionButton) dialog.findViewById(R.id.btnSend);
        progressBar = (ProgressBar) dialog.findViewById(R.id.mProgressBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);

        btnSend.setOnLongClickListener(btnSendHoldListener);
        btnSend.setOnTouchListener(btnSendTouchListener);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsSend == true) {
                    Toast.makeText(Reply.this, "Send", Toast.LENGTH_SHORT).show();
                    circleProgressbar.setVisibility(View.VISIBLE);
                    // showing a progressbar here
                    SimpleTooltip simpleTooltip=    new SimpleTooltip.Builder(Reply.this)
                            .anchorView(btnSend)
                            .text("Tap and hold to record")
                            .arrowColor(Color.parseColor("#000000"))
                            .gravity(Gravity.TOP)
                            .backgroundColor(Color.parseColor("#000000"))
                            .textColor(Color.parseColor("#FFFFFF"))
                            .dismissOnOutsideTouch(false)
                            .dismissOnInsideTouch(true)
                            .build();
                    //simpleTooltip.show();

                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    btnSend.setVisibility(View.GONE);
                }
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        edtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    btnSend.setImageResource(R.drawable.ic_mic);
                    IsSend = false;
                } else {
                    btnSend.setImageResource(R.drawable.ic_send);
                    IsSend = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }


}
