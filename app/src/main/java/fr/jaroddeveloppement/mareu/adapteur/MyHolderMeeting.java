package fr.jaroddeveloppement.mareu.adapteur;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaroddeveloppement.mareu.R;

public class MyHolderMeeting extends RecyclerView.ViewHolder {

    TextView mListMeeting;
    ImageButton mImageButton;

    public MyHolderMeeting(@NonNull View itemView) {
        super(itemView);

        mListMeeting = itemView.findViewById(R.id.listMeeting);
        mImageButton = itemView.findViewById(R.id.icDelete);

    }
}