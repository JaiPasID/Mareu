package fr.jaroddeveloppement.mareu.ui;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ImageButton;

import fr.jaroddeveloppement.mareu.R;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageButton mBoutonFiltre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.namToolBar);
        mBoutonFiltre = findViewById(R.id.boutonFiltre);





        init();
    }


    public void init(){

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ma Réu");
    }

}