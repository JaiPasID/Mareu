package fr.jaroddeveloppement.mareu.adapteur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;


public class MyRoomRecyclerViewAdapteur extends RecyclerView.Adapter<MyHolderRoom>  {


    private final List<Room> mRoom;


    public MyRoomRecyclerViewAdapteur(List<Room> mRoom) {
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
    }

    @Override
    public int getItemCount() {
        return mRoom.size();
    }
}