package fr.jaroddeveloppement.mareu.dialogFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.adapteur.MyUserRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.event.GetUserEvent;
import fr.jaroddeveloppement.mareu.model.Users;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.service.GetUsersFromSwitch;

public class DialogFragmentListUsers extends DialogFragment {

    private ApiService mApiServie;
    private RecyclerView mRecyclerView;
    private MyUserRecyclerViewAdapter myUserRecyclerViewAdapter;
    private List<Users> mUserSwitch = new ArrayList<>();
    Button mValider;
    private GetUsersFromSwitch mGetUsersFromSwitch;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recyclerview_user, container);
        mValider = rootView.findViewById(R.id.selctedUsers);
        mApiServie = DI.getApiService();
        mRecyclerView = rootView.findViewById(R.id.recyclerViewUser);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        myUserRecyclerViewAdapter = new MyUserRecyclerViewAdapter(mApiServie.getUser());

        mRecyclerView.setAdapter(myUserRecyclerViewAdapter);

        this.getDialog().setTitle("Liste des utilisateurs");

        mValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mGetUsersFromSwitch.GetUser(mUserSwitch);
                dismiss();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getSwitchChange(GetUserEvent event) {

        if (!mUserSwitch.contains(event.mUsers)) {
            mUserSwitch.add(event.mUsers);
        }


    }

    public void setUserListener(GetUsersFromSwitch getUserFromDialogFragment) {
        this.mGetUsersFromSwitch = getUserFromDialogFragment;
    }
}