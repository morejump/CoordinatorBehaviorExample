package saulmm.myapplication.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import saulmm.myapplication.Models.CorrectionModel;
import saulmm.myapplication.R;

/**
 * Created by morejump on 28/07/2017.
 */

public class AdapterCorrection extends RecyclerView.Adapter<AdapterCorrection.ViewHolder> {

    private List<CorrectionModel> ListCorrectionModel;

    public AdapterCorrection(List<CorrectionModel> listCorrectionModel) {
        ListCorrectionModel = listCorrectionModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemCorrectionView = inflater.inflate(R.layout.item_on_list_correction, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemCorrectionView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CorrectionModel correctionModel = ListCorrectionModel.get(position);
        //
       // holder.imgAvatar= correctionModel.getImgAvatar();
       // holder.imgflag= correctionModel.getImgflag();
        //
        holder.name.setText(correctionModel.getName());
        holder.country.setText(correctionModel.getCountry());
        holder.description.setText(correctionModel.getDescription());
        holder.countcomment.setText(""+correctionModel.getCountcomment()+" comment");
        holder.countrating.setText("("+correctionModel.getCountrating()+")");
        holder.timepost.setText(correctionModel.getTimepost());
    }

    @Override
    public int getItemCount() {
        return ListCorrectionModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        GradientDrawable drawable;

        public ImageView imgflag;
        public ImageView imgAvatar;
        public TextView name;
        public TextView country;
        public TextView description;
        public TextView timepost;
        public TextView countcomment;
        public TextView countrating;

        public  ViewHolder(View itemView) {

            super(itemView);
           imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            //GlideApp.with(this).load("http://goo.gl/gEgYUd").into(imgAvatar);
            Glide.with(itemView.getContext()).load(R.drawable.sea).apply(RequestOptions.circleCropTransform()).into(imgAvatar);

           /* drawable= new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(Color.parseColor("#1E1EF0"));
            drawable.setShape(GradientDrawable.RECTANGLE);
            //
            imgAvatar.setBackground(drawable);*/
            //imgAvatar.setImageResource(R.drawable.sea);
            //
            imgflag = (ImageView) itemView.findViewById(R.id.imgflag);
            name = (TextView) itemView.findViewById(R.id.txtName);
            country = (TextView) itemView.findViewById(R.id.txtCountry);
            description = (TextView) itemView.findViewById(R.id.txtdescription);
            timepost = (TextView) itemView.findViewById(R.id.txttimepost);
            countcomment = (TextView) itemView.findViewById(R.id.txtcountcomment);
            countrating = (TextView) itemView.findViewById(R.id.txtcountrating);
        }
    }
}
