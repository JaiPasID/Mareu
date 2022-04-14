package fr.jaroddeveloppement.mareu.adapteur;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaroddeveloppement.mareu.R;

public class MyHolderRoom extends RecyclerView.ViewHolder {

    TextView mListRoom;
    View mRoomColor;


    public MyHolderRoom(@NonNull View itemView) {
        super(itemView);

        mListRoom = itemView.findViewById(R.id.listRoom);
        mRoomColor = itemView.findViewById(R.id.colorMeeting);


    }
}
