package fr.jaroddeveloppement.mareu.adapteur;


import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.text.ParseException;
import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.event.DeleteEvent;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Users;
import fr.jaroddeveloppement.mareu.service.Utility;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyHolderMeeting> {


    private final List<Meeting> mMeeting;


    public MyMeetingRecyclerViewAdapter(List<Meeting> mMeeting) {
        this.mMeeting = mMeeting;
    }


    @NonNull
    @Override
    public MyHolderMeeting onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_meetings, parent, false);
        MyHolderMeeting holder = new MyHolderMeeting(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderMeeting holder, int position) {
        String mDate = "";
        Meeting meeting = mMeeting.get(position);

        try {
             mDate = Utility.dateToDesplay(meeting.getDate());
        } catch (ParseException pE) {
            pE.printStackTrace();
        }
        holder.mSujet.setText(meeting.getMeetingSubject());
        holder.mRoomName.setText(meeting.getRoom().getNomDeLaSalle());
        holder.mColorRoom.setBackgroundResource(R.drawable.circle);
        GradientDrawable drawable = (GradientDrawable) holder.mColorRoom.getBackground();
        drawable.setColor(ContextCompat.getColor(holder.mColorRoom.getContext(), meeting.getRoom().getColorRoom()));
        holder.mDateMeeting.setText(mDate);
        holder.mHeureMeeting.setText(meeting.getTime());
        String emails = "";
        for(Users users : meeting.getUsers()) {
            emails += users.getMail();
        }
       holder.mParticiapantMeeting.setText(emails);
        holder.mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                EventBus.getDefault().post(new DeleteEvent(meeting));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeeting.size();
    }
}