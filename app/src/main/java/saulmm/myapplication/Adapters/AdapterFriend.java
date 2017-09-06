package saulmm.myapplication.Adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import saulmm.myapplication.Models.FriendModel;
import saulmm.myapplication.R;

/**
 * Created by morejump on 07/08/2017.
 */

public class AdapterFriend extends RecyclerView.Adapter<AdapterFriend.RecyclerViewHolder> {

    private ScaleAnimation scal = new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, (float) 0.5, Animation.RELATIVE_TO_SELF, (float) 0.5);
    private Animation fadeOut = new AlphaAnimation(1, 0);
    private Context context;
    private List<FriendModel> listFriend = new ArrayList<>();

    public AdapterFriend(List<FriendModel> listFriend, Context context) {
        this.listFriend = listFriend;
        this.context = context;
        //
        scal.setDuration(300);
        scal.setFillAfter(true);
        //
        fadeOut.setFillAfter(true);
        fadeOut.setDuration(500);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.item_friend_request, parent, false);
        return new RecyclerViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        holder.txtName.setText(listFriend.get(position).getName());
        Glide.with(context).load(listFriend.get(position).getUrlAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.imgAvatar);
        Glide.with(context).load(R.drawable.ic_grey_tick).apply(RequestOptions.circleCropTransform()).into(holder.imgConfirm);
        Glide.with(context).load(R.drawable.ic_grey_cross).apply(RequestOptions.circleCropTransform()).into(holder.imgDelete);
        Glide.with(context).load(R.drawable.ic_blue_tick).apply(RequestOptions.circleCropTransform()).into(holder.imgBlueConfirm);
        holder.imgConfirm.setClickable(true);
        //
        holder.imgConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imgConfirm.setVisibility(View.INVISIBLE);
                holder.imgBlueConfirm.startAnimation(scal);
                //
                scal.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ObjectAnimator anim = ObjectAnimator.ofFloat(holder.mFrameLayout, "translationX", 0,150);
                        anim.setDuration(300);
                        anim.start();
                        holder.imgDelete.startAnimation(fadeOut);
                       // ((ViewGroup)holder.imgBlueConfirm.getParent()).removeView(holder.imgDelete);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        holder.imgDelete.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
    }


    @Override
    public int getItemCount() {
        return listFriend.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        FrameLayout mFrameLayout;
        TextView txtName;
        ImageView imgAvatar, imgConfirm, imgDelete, imgBlueConfirm;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mFrameLayout= (FrameLayout) itemView.findViewById(R.id.myFrameLayout);
            imgBlueConfirm = (ImageView) itemView.findViewById(R.id.imgBlueConfirm);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            imgConfirm = (ImageView) itemView.findViewById(R.id.imgConfirm);
            imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);

        }

    }
}
