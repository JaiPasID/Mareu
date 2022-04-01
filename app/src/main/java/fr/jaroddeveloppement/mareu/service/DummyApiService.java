package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;

public class DummyApiService implements ApiService {


    private List<Users> user = DummyUtilisateurGenerator.dummyUsers;
    private List<Room> listRooms = DummySalleGenerator.DUMMY_SALLE;
    private List<Meeting> meetings = new ArrayList<>();

    private List<Meeting> meetingsFilterByDate = new ArrayList<>();
    private List<Meeting> roomMeeting = new ArrayList<>();




    @Override
    public List<Users> getUser() {
        return user;
    }

    @Override
    public List<Room> getRoom() {
        return listRooms;
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


        for (int i = 0 ; i <meetings.size(); i++){
        Meeting element = meetings.get(i);
        if (meetings.get(i).getRoom().getNomDeLaSalle().equals(room.getNomDeLaSalle())){
            roomMeeting.add(meetings.get(i));
        }
        }

        return roomMeeting;
    }

    @Override
    public List<Meeting> filterByDate(String date) {

        for (int i = 0 ; i < meetings.size(); ++i){
            if (meetings.get(i).getDate().equals(date)){
                meetingsFilterByDate.add(meetings.get(i));
            }
        }


        return meetingsFilterByDate;
    }




}