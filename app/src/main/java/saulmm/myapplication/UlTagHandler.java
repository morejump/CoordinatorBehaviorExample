package saulmm.myapplication;

import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

/**
 * Created by morejump on 02/08/2017.
 */

public class UlTagHandler implements  Html.TagHandler {
    @Override
    public void handleTag(boolean b, String s, Editable editable, XMLReader xmlReader) {
        if(s.equals("ul") && !b) editable.append("\n");
        if(s.equals("li") && b) editable.append("\n• ");
    }
}
