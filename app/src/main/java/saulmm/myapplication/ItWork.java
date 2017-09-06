package saulmm.myapplication;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;
public class ItWork extends AppCompatActivity {
    //
    private WebView webView;
    private TextView  txtItWork;
    MyExpandableLayout expand1, expand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_work);
        bindViews();
        String str="<p style=\"font-size:150%;\"><b>It works!</b></p>\n" +
                "<font color=\"#000000\"><p style=\"color:black;\" >Learning a foreign language isn’t always easy, but if you pick the right language and take the time to learn, it can really pay off</p></font>\n" +
                "<font color=\"#778086\"><p >Learning a foreign language isn’t always easy, but if you pick the right language and take the time to learn, it can really pay off</p>\n" +
                "<p >Learning a foreign language isn’t always easy, but if you pick the right language and take the time to learn, it can really pay off</p>\n" +
                "<p >Picking a second (or third) language to learn is a broad subject, and it’s ultimately a very personal choice. Perhaps you want to live somewhere new, or maybe you’re looking to explore business opportunities.</p>\n" +
                "<p >Picking a second (or third) language to learn is a broad subject, and it’s ultimately a very personal choice. Perhaps you want to live somewhere new, or maybe you’re looking to explore business opportunities.</p>\n" +
                "<font color=\"#000000\"><strong>• </strong></font>38% of Americans said gay and lesbian relations were morally acceptable in 2002</br>\n" +
                "<font color=\"#000000\"><strong>• </strong></font>Different apps and devices require different methods for accessing Unicode characters, but typically on a Mac you can access them via the special characters interface</br>\n" +
                "<font color=\"#000000\"><strong>• </strong></font>38% of Americans said gay and lesbian relations were morally acceptable in 2002</br>\n" +
                "<font color=\"#000000\"><strong>• </strong></font>110,000 characters, but aside from the full Latin alphabet, numerals and punctuation symbols, the most recognisable characters are probably</br>\n" +
                "<font color=\"#000000\"><strong>• </strong></font>38% of Americans said gay and lesbian relations were morally acceptable in 2002</br>\n" +
                "<p >Picking a second (or third) language to learn is a broad subject, and it’s ultimately a very personal choice. Perhaps you want to live somewhere new, or maybe you’re looking to explore business opportunities.</p></font>\n" +
                "<font color=\"#000000\"><p style=\"font-size:120%;color:black;\" >\"Learning a foreign language isn’t always easy, but if you pick the right language and take the time to learn, it can really pay off\"</p></font>";
        webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        webView.setBackgroundColor(Color.TRANSPARENT);
        expand1.Detail = "No matter how difficult a challenge is, you are capable of completing it by using your exceptionally quick wits and tremendous";
        expand1.Init();
        //
        expand2.Title = "Practice with 60 million users worldwide";
        expand2.Detail = "No matter how difficult a challenge is, you are capable of completing it by using your exceptionally quick wits and tremendous";
        expand2.Init();

    }
    //
    private void bindViews() {
        webView= (WebView) findViewById(R.id.myWebview);
        expand1 = (MyExpandableLayout)findViewById(R.id.expand1);
        expand2 = (MyExpandableLayout)findViewById(R.id.expand2);

    }
}
