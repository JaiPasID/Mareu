package fr.jaroddeveloppement.mareu.adapteur;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaroddeveloppement.mareu.R;

public class MyHolderUsers extends RecyclerView.ViewHolder {

    TextView mEmail;
    SwitchCompat mSwitch;


    public MyHolderUsers(@NonNull View itemView) {
        super(itemView);

        mEmail = itemView.findViewById(R.id.userEmail);
        mSwitch = itemView.findViewById(R.id.changeSwitch);
    }
}