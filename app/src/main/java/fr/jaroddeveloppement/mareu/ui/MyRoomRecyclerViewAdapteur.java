package fr.jaroddeveloppement.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Room;

public class MyRoomRecyclerViewAdapteur extends RecyclerView.Adapter<MyRoomRecyclerViewAdapteur.ViewHolder> {


    private final List<Room> mRooms;

    public MyRoomRecyclerViewAdapteur(List<Room> mRooms) {
        this.mRooms = mRooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_dialog_fragment_list_room, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Room room = mRooms.get(position);
        holder.mTextView.setText(room.getNomDeLaSalle());

    }


    @Override
    public int getItemCount() {
        return mRooms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = mTextView.findViewById(R.id.listRoom);
        }
    }
}