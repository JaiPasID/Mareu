package fr.jaroddeveloppement.mareu.model;


public class Meeting  {

    Users users;
    Room room;

    String date;
    String startingTime;
    String endTime;
    String meetingSubject;


    public Meeting(Users users, Room room) {
        this.users = users;
        this.room = room;
    }

    public Meeting(Users users, Room room, String date, String startingTime, String endTime, String meetingSubject) {
        this.users = users;
        this.room = room;
        this.date = date;
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.meetingSubject = meetingSubject;
    }
}
