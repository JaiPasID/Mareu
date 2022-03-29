package fr.jaroddeveloppement.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.dialogFragment.DialogFragmentListUsers;

import fr.jaroddeveloppement.mareu.model.Users;
import fr.jaroddeveloppement.mareu.dialogFragment.DatePickerFragment;
import fr.jaroddeveloppement.mareu.dialogFragment.TimePickerFragment;
import fr.jaroddeveloppement.mareu.service.ApiService;

public class AddMeetingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


   private ApiService apiService;
   Button mSelectionParticipant, mButtonDate, mButtonTime, mValidation;
   TextView mDate, mTime, mUserSelection;
   public static String TAG = "User";
   public static String TAGDATE ="Date Picker";
   public static String TAGTIME ="Time Picker";
   Users users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        apiService = DI.getApiService();






        mSelectionParticipant = findViewById(R.id.buttonUser);
        mUserSelection = findViewById(R.id.userSelection);
        mButtonDate = findViewById(R.id.buttonDate);
        mDate = findViewById(R.id.dateSelection);
        mButtonTime = findViewById(R.id.buttonTime);
        mTime = findViewById(R.id.timeSelection);
        mValidation = findViewById(R.id.validationMeeting);



        mButtonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), TAGDATE);
            }
        });

        mButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),TAGTIME);
            }
        });

        mSelectionParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogFragmentListUsers mDialogFragmentListUsers = new DialogFragmentListUsers();
                mDialogFragmentListUsers.show(getSupportFragmentManager(),TAG);
                onUserSet(users.getMail());


            }
        });

        mValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        mDate.setText(currentDate);

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

        mTime.setText(hour + " Heures " + minute + " Minutes " );

    }

    public void onUserSet(String mail){

        mUserSelection.setText(mail);
    }

}