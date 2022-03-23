package fr.jaroddeveloppement.mareu.ui;

import  android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import fr.jaroddeveloppement.mareu.event.DeleteEvent;
import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Meeting;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {



    private final List<Meeting> mMeeting;

    public MyMeetingRecyclerViewAdapter(List<Meeting> mMeeting) {
        this.mMeeting = mMeeting;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gestion_list, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meeting meeting = mMeeting.get(position);
        holder.mTextView.setText(meeting.getMeetingSubject());
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mTextView;
        ImageButton mImageButton;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = mView.findViewById(R.id.colorMeeting);
            mTextView = mTextView.findViewById(R.id.listReunion);
            mImageButton = mImageButton.findViewById(R.id.icDelete);
        }
    }
}
