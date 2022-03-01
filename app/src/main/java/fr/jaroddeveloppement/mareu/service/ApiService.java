package fr.jaroddeveloppement.mareu.service;

import java.util.List;

import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;

public interface ApiService {


    List <Users> getUser();
    List <Room> getRoom();
    List <Meeting>getMeeting();


    /** Add an appointment*/

   void addMeeting(Meeting meetings);

   /** Remove an appointment */
   void removeMetting(Meeting meeting);

}
