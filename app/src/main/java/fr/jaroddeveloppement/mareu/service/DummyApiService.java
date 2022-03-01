package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;

public class DummyApiService implements ApiService {


    private List<Users> user = DummyUtilisateurGenerator.dummyUsers;
    private List<Room> meetingRoom = DummySalleGenerator.DUMMY_SALLE;
    private List<Meeting> meetings = new ArrayList<>();



    @Override
    public List<Users> getUser() {
        return user;
    }

    @Override
    public List<Room> getRoom() {
        return meetingRoom;
    }

    @Override
    public List<Meeting> getMeeting() {
        return meetings;
    }

    @Override
    public void addMeeting(Meeting meeting) {

        meetings.add(meeting);
    }

    @Override
    public void removeMetting(Meeting meeting) {

        meetings.remove(meeting);
    }


}
