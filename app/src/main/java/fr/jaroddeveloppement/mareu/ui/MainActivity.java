package fr.jaroddeveloppement.mareu.ui;


import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.PrimitiveIterator;

import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.event.DeleteEvent;
import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;
import fr.jaroddeveloppement.mareu.adapteur.MyMeetingRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.adapteur.MyRoomRecyclerViewAdapteur;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.dialogFragment.DialogFragmentListRoom;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<Meeting> mMeeting;
    private ApiService apiService;
    private List<Room> mRoom;

    private List<Users> mUsers;


    private FloatingActionButton mAddMeeting;


    private final int ACTIVITY_REQUEST_CODE = 40;





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.filterDate:
                // todo faire le filtre du cas 1
            case R.id.filterRoom:

                DialogFragmentListRoom roomsListFragment = new DialogFragmentListRoom();
                roomsListFragment.show(getSupportFragmentManager(), "RoomsListFragment");


                // todo faire le filtre du cas 1 dialogue fragment
            case R.id.reset_filter:
                // todo faire le filtre du cas 1

                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.namToolBar);
        mRecyclerView = findViewById(R.id.recyclerViewMeeting);
        mAddMeeting = findViewById(R.id.buttonAddMeeting);

        apiService = DI.getApiService();

        init();



        mAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, AddMeetingActivity.class);
                registerForActivityResult(intent, ACTIVITY_REQUEST_CODE);
            }
        });
    }

    private void registerForActivityResult(Intent intent, int activityRequestCode) {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onDeleteMeeting(DeleteEvent event) {

        apiService.removeMetting(event.meeting);

    }

    public void init(){

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ma Réu");


    }
    public void initList() {

        mMeeting = apiService.getMeeting();
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(mMeeting));

    }

    public void InitFilterRoom(){

        mRoom = apiService.getRoom();
       // mRecyclerView.setAdapter(new MyRoomRecyclerViewAdapter(mRoom));


    }


}