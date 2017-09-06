package saulmm.myapplication.Models;

import android.widget.ImageView;

import java.util.logging.StreamHandler;

/**
 * Created by morejump on 28/07/2017.
 */
// a model for adapter correction

public class CorrectionModel {
    ImageView imgAvatar;
    ImageView imgflag;
    private  String name;
    private String country;
    private  String description;
    private String  timepost;
    private  int countcomment;
    private  int countrating;
    //
    public ImageView getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(ImageView imgAvatar) {
        this.imgAvatar = imgAvatar;
    }
    public ImageView getImgflag() {
        return imgflag;
    }

    public void setImgflag(ImageView imgflag) {
        this.imgflag = imgflag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimepost() {
        return timepost;
    }

    public void setTimepost(String timepost) {
        this.timepost = timepost;
    }

    public int getCountcomment() {
        return countcomment;
    }

    public void setCountcomment(int countcomment) {
        this.countcomment = countcomment;
    }

    public int getCountrating() {
        return countrating;
    }

    public void setCountrating(int countrating) {
        this.countrating = countrating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CorrectionModel(ImageView imgAvatar, ImageView imgflag, String name, String country, String description, String timepost, int countcomment, int countrating) {
        this.imgAvatar = imgAvatar;
        this.imgflag = imgflag;
        this.name = name;
        this.country = country;
        this.description = description;
        this.timepost = timepost;
        this.countcomment = countcomment;
        this.countrating = countrating;
    }
}
