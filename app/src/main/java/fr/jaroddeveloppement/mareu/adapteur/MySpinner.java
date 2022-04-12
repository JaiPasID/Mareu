package fr.jaroddeveloppement.mareu.adapteur;


import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import fr.jaroddeveloppement.mareu.model.Room;

public class MySpinner extends ArrayAdapter<Room> {


    public MySpinner(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);
    }


}


