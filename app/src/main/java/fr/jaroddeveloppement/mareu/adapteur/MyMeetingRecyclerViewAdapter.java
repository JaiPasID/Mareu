package fr.jaroddeveloppement.mareu.adapteur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.event.DeleteEvent;
import fr.jaroddeveloppement.mareu.model.Meeting;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyHolderMeeting> {


    private final List<Meeting> mMeeting;

    public MyMeetingRecyclerViewAdapter(List<Meeting> mMeeting) {
        this.mMeeting = mMeeting;
    }


    @NonNull
    @Override
    public MyHolderMeeting onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        MyHolderMeeting holder = new MyHolderMeeting(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderMeeting holder, int position) {

        Meeting meeting = mMeeting.get(position);
        holder.mListMeeting.setText(meeting.getMeetingSubject());
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