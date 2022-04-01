package fr.jaroddeveloppement.mareu.dialogFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.adapteur.MyUserRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.service.ApiService;

public class DialogFragmentListUsers extends DialogFragment {

    private ApiService mApiServie;
    private RecyclerView mRecyclerView;
    private MyUserRecyclerViewAdapter myUserRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.recyclerview_user, container);

        mApiServie = DI.getApiService();
        mRecyclerView = rootView.findViewById(R.id.recyclerViewUser);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        myUserRecyclerViewAdapter = new MyUserRecyclerViewAdapter(mApiServie.getUser());

        mRecyclerView.setAdapter(myUserRecyclerViewAdapter);

        this.getDialog().setTitle("Liste des utilisateurs");

        return rootView;
    }
}