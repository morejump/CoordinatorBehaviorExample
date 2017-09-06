package saulmm.myapplication.Models;

/**
 * Created by morejump on 07/08/2017.
 */

public class FriendModel {
    private String name;
    private  String urlAvatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public FriendModel(String name, String urlAvatar) {
        this.name = name;
        this.urlAvatar = urlAvatar;
    }

    public FriendModel() {
        this.name = "Binh Do";
        this.urlAvatar = "http://media.phunutoday.vn/files/tho_nguyen/2017/05/31/ngoc-trinh-4-1429-phunutoday.jpg";
    }
}
