package fr.jaroddeveloppement.mareu.ui;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.adapteur.MyMeetingRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.adapteur.MyRoomRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.dialogFragment.DatePickerFragment;
import fr.jaroddeveloppement.mareu.dialogFragment.DialogFragmentListRoom;
import fr.jaroddeveloppement.mareu.event.DeleteEvent;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.service.GetRoomFromDialogFragment;
import fr.jaroddeveloppement.mareu.service.utility;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, GetRoomFromDialogFragment {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<Meeting> mMeeting;

    private ApiService apiService;
    private List<Room> mRoom;

    private List<Users> mUsers;


    private FloatingActionButton mAddMeeting;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.filterDate:

                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(), "DateListFragment");
                break;


            case R.id.filterRoom:

                DialogFragmentListRoom roomsListFragment = new DialogFragmentListRoom();
                roomsListFragment.setRoomListener(this);
                roomsListFragment.show(getSupportFragmentManager(), "RoomsListFragment");


            case R.id.reset_filter:

                initList();


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
                Intent intent = new Intent(MainActivity.this, AddMeetingActivity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        InitFilterRoom();
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();

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

    public void init() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ma Réu");


    }

    public void initList() {

        mMeeting = apiService.getMeeting();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(mMeeting));


    }

    public void InitFilterRoom() {

        mRoom = apiService.getRoom();

        mRecyclerView.setAdapter(new MyRoomRecyclerViewAdapter(mRoom));


    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String myDate = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());
        try {
             myDate = utility.formatDate(currentDate);
        } catch (ParseException pE) {
            pE.printStackTrace();
        }
        List<Meeting> meetingsFiltreByDate = apiService.filterByDate(myDate);
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetingsFiltreByDate));


    }

    @Override
    public void GetRoom(Room mroom) {
        List<Meeting> meetingsFiltreByRoom = apiService.filterByRoom(mroom);
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetingsFiltreByRoom));

    }
}