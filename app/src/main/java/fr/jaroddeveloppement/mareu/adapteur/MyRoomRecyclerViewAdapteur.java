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


public class MyRoomRecyclerViewAdapteur extends RecyclerView.Adapter<MyHolder>  {


    private final List<Room> mRoom;


    public MyRoomRecyclerViewAdapteur(List<Users> mRoom) {
        this.mRoom = mRoom;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_room, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Room room = mRoom.get(position);
        holder.mListRoom.setText(room.getNomDeLaSalle());
    }

    @Override
    public int getItemCount() {
        return mRoom.size();
    }
}