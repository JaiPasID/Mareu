package fr.jaroddeveloppement.mareu.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.model.Room;


public class DialogueFragment extends DialogFragment {

    ListView mListeView;
    ApiService mApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);




         View rootView = inflater.inflate(R.layout.activity_dialog_fragment, container, false);

        mListeView = rootView.findViewById(R.id.listeView);

        mApiService = DI.getApiService();
        List<Room> meetingRoomList = mApiService.getRoom();

       // RecyclerView recyclerView = rootView.findViewById(R.id.fragment_rooms_list_recycler_view);

       //RoomListFragmentRecyclerViewAdapter roomListFragmentRecyclerViewAdapter =
        //        new RoomListFragmentRecyclerViewAdapter(meetingRoomList);

       // roomListFragmentRecyclerViewAdapter.setOnItemClickListener(this);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setAdapter(roomListFragment);

        return rootView;
    }
}




