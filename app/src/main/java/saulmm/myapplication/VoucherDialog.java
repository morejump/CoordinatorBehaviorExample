package saulmm.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Window;

import saulmm.myapplication.R;

/**
 * Created by morejump on 01/09/2017.
 */

public class VoucherDialog extends Dialog {

    public VoucherDialog(@NonNull Context context) {
        super(context);
        Init();
    }

    public VoucherDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        Init();
    }

    protected VoucherDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        Init();
    }
    private  void Init(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.voucher_dialog);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

    }

}
