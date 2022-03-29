package fr.jaroddeveloppement.mareu.adapteur;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaroddeveloppement.mareu.R;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView mListMeeting, mListUser, mListRoom;
    ImageButton mImageButton;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        mListMeeting = itemView.findViewById(R.id.listMeeting);
        mListRoom = itemView.findViewById(R.id.listRoom);
        mListUser = itemView.findViewById(R.id.listUsers);
        mImageButton = itemView.findViewById(R.id.icDelete);

    }
}
