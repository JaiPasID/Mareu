package fr.jaroddeveloppement.mareu.adapteur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Users;

public class MyUserRecyclerViewAdapter extends RecyclerView.Adapter<MyHolder>  {



    private final List<Users> mUser;

    public MyUserRecyclerViewAdapter(List<Users> mUser) {
        this.mUser = mUser;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users,parent,false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Users users = mUser.get(position);
        holder.mListUser.setText(users.getMail());

    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }
}
