package fr.jaroddeveloppement.mareu.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import fr.jaroddeveloppement.mareu.R;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;


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
                // todo faire le filtre du cas 1
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






        init();
    }


    public void init(){

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ma Réu");
    }

}