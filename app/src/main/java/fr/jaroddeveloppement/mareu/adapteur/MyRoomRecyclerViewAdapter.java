package fr.jaroddeveloppement.mareu.adapteur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.event.GetRoomEvent;
import fr.jaroddeveloppement.mareu.model.Room;


public class MyRoomRecyclerViewAdapter extends RecyclerView.Adapter<MyHolderRoom> {


    private final List<Room> mRoom;


    public MyRoomRecyclerViewAdapter(List<Room> mRoom) {
        this.mRoom = mRoom;
    }

    @NonNull
    @Override
    public MyHolderRoom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_room, parent, false);
        MyHolderRoom holder = new MyHolderRoom(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderRoom holder, int position) {
        Room room = mRoom.get(position);
        holder.mListRoom.setText(room.getNomDeLaSalle());
        holder.mRoomColor.setBackgroundColor(room.getColorRoom());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new GetRoomEvent(room));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRoom.size();
    }
}