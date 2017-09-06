package saulmm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import saulmm.myapplication.Adapters.AdapterNotification;
import saulmm.myapplication.Models.NotificationModel;
import saulmm.myapplication.Utils.SpacesItemDecoration;

public class Notification extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterNotification adapterNotification;
    private List<NotificationModel> notificationModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        init();
    }
    private  void init(){
        recyclerView= (RecyclerView) findViewById(R.id.myRecyclerView);
        notificationModels= new ArrayList<>();

        for (int i=0;i<10;i++){
            notificationModels.add(new NotificationModel());
        }
        // this
        recyclerView.addItemDecoration(new SpacesItemDecoration(30));
        adapterNotification= new AdapterNotification(notificationModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNotification);

    }
}
