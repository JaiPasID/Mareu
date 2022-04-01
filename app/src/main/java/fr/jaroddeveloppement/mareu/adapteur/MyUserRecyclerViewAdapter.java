package fr.jaroddeveloppement.mareu.adapteur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Users;

public class MyUserRecyclerViewAdapter extends RecyclerView.Adapter<MyHolderUsers>  {



    private final List<Users> mUser;

    public MyUserRecyclerViewAdapter(List<Users> mUser) {
        this.mUser = mUser;
    }


    @NonNull
    @Override
    public MyHolderUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users,parent,false);
        MyHolderUsers holder = new MyHolderUsers(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderUsers holder, int position) {

        Users user = mUser.get(position);
        holder.mEmail.setText(user.getMail());

    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }
}
