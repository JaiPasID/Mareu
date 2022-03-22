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

    private List<Meeting> dateMeeting = new ArrayList<>();
    private List<Meeting> roomMeeting = new ArrayList<>();



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

    @Override
    public List<Meeting> filterByRoom(Room room) {
        //todo faire une boucle sur les meetings et recupérer les meeting qui ont la room = room en parametre
        return roomMeeting;
    }

    @Override
    public List<Meeting> filterByDate(String date) {
        //todo faire une boucle sur les meetings et recupérer les meeting qui ont la date = date en parametre
        return dateMeeting;
    }




}
