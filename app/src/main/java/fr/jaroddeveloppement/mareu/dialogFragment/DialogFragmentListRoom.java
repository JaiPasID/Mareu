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
import fr.jaroddeveloppement.mareu.adapteur.MyRoomRecyclerViewAdapteur;
import fr.jaroddeveloppement.mareu.service.ApiService;


public class DialogFragmentListRoom extends DialogFragment {

    private ApiService mApiService;
    private RecyclerView mRecyclerView;
    private MyRoomRecyclerViewAdapteur mMyRoomRecyclerViewAdapteur;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialog_fragment_list_room, container);

        mRecyclerView = rootView.findViewById(R.id.recyclerViewRoom);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mMyRoomRecyclerViewAdapteur = new MyRoomRecyclerViewAdapteur(mApiService.getUser());

        mRecyclerView.setAdapter(mMyRoomRecyclerViewAdapteur);

        this.getDialog().setTitle("Liste des Room");

        return rootView;
    }

}




