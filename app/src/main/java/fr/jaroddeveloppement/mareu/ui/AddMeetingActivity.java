package fr.jaroddeveloppement.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.jaroddeveloppement.mareu.DI;
import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.service.ApiService;

public class AddMeetingActivity extends AppCompatActivity {


    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        apiService = DI.getApiService();


        // todo add meeting quand formulaire rempli
    }
}