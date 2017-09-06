package saulmm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import saulmm.myapplication.Adapters.AdapterFriend;
import saulmm.myapplication.Models.FriendModel;
import saulmm.myapplication.Utils.SpacesItemDecoration;

public class friend_request extends AppCompatActivity {
    private RecyclerView FriendRecyclerView;
    private AdapterFriend adapterFriend;
    private List<FriendModel> friendModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_request);
        bindViews();

    }
    private  void bindViews(){
        friendModels= new ArrayList<>();
       for (int i=0;i<10;i++){
           friendModels.add(new FriendModel());
       };
        FriendRecyclerView= (RecyclerView) findViewById(R.id.recyclerFriend);
        FriendRecyclerView.addItemDecoration(new SpacesItemDecoration(10000));
        adapterFriend= new AdapterFriend(friendModels, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        FriendRecyclerView.setLayoutManager(layoutManager);
        FriendRecyclerView.setAdapter(adapterFriend);
    }
}
