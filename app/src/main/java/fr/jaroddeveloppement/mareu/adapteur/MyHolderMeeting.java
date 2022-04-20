package fr.jaroddeveloppement.mareu.adapteur;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaroddeveloppement.mareu.R;

public class MyHolderMeeting extends RecyclerView.ViewHolder {


    TextView mSujet, mRoomName, mDateMeeting, mHeureMeeting, mParticiapantMeeting;
    View mColorRoom;
    ImageButton mImageButton;

    public MyHolderMeeting(@NonNull View itemView) {
        super(itemView);

        mSujet = itemView.findViewById(R.id.subjectItemMeeting);
        mRoomName = itemView.findViewById(R.id.NomDeLaSalle);
        mImageButton = itemView.findViewById(R.id.icDelete);
        mDateMeeting = itemView.findViewById(R.id.DateMeeting);
        mHeureMeeting = itemView.findViewById(R.id.HeureMeeting);
        mColorRoom = itemView.findViewById(R.id.colorMeeting);
        mParticiapantMeeting = itemView.findViewById(R.id.particiapantMeeting);

    }
}