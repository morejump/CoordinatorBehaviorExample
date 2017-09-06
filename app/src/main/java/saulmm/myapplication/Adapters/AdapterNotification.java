package saulmm.myapplication.Adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import saulmm.myapplication.Models.FriendModel;
import saulmm.myapplication.Models.NotificationModel;
import saulmm.myapplication.R;

/**
 * Created by morejump on 09/08/2017.
 */

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.RecyclerViewHolder>{
    private List<NotificationModel> listNotify = new ArrayList<>();

    public AdapterNotification(List<NotificationModel> listNotify) {
        this.listNotify = listNotify;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.item_notification, parent, false);
        return new AdapterNotification.RecyclerViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        // do something here later
        String name = listNotify.get(position).getName();
        final SpannableStringBuilder sb = new SpannableStringBuilder(name+" has asked you to correct their excise");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        sb.setSpan(bss, 0, name.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
      //  holder.txtTimePost.

//        holder.txtNotify.setText(sb);

    }

    @Override
    public int getItemCount() {
        return listNotify.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtNotify, txtTimePost;
        ImageView imgAvatar;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtNotify = (TextView) itemView.findViewById(R.id.txtNotify);
            txtTimePost = (TextView) itemView.findViewById(R.id.txtTimePost);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
        }

    }
}
