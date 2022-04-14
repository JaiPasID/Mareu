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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.adapteur.MyRoomRecyclerViewAdapter;
import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.event.GetRoomEvent;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.service.GetRoomFromDialogFragment;


public class DialogFragmentListRoom extends DialogFragment {

    private ApiService mApiService;
    private RecyclerView mRecyclerView;
    private MyRoomRecyclerViewAdapter mMyRoomRecyclerViewAdapteur;
    private GetRoomFromDialogFragment mGetRoomFromDialogFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recyclerview_room, container);

        mApiService = DI.getApiService();
        mRecyclerView = rootView.findViewById(R.id.recyclerViewRoom);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMyRoomRecyclerViewAdapteur = new MyRoomRecyclerViewAdapter(mApiService.getRoom());

        mRecyclerView.setAdapter(mMyRoomRecyclerViewAdapteur);

        this.getDialog().setTitle("Liste des Room");

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getSelectedRoom(GetRoomEvent event) {

        Room mMyRoom = event.mRoom;

        mGetRoomFromDialogFragment.GetRoom(mMyRoom);
        dismiss();

    }

    public void setRoomListener(GetRoomFromDialogFragment mGetRoomFromDialogFragment) {

        this.mGetRoomFromDialogFragment = mGetRoomFromDialogFragment;
    }
}