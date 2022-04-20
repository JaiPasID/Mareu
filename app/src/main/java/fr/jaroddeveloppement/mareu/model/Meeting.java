package fr.jaroddeveloppement.mareu.model;


import java.util.List;

public class Meeting {

    List<Users> users;
    Room room;


    private String date;
    private String time;
    private String meetingSubject;





    /**
     * Constructor
     *
     * @param users
     * @param room
     * @param date
     * @param time
     * @param meetingSubject
     */


    public Meeting(List<Users> users, Room room, String date, String time, String meetingSubject) {
        this.users = users;
        this.room = room;
        this.date = date;
        this.time = time;
        this.meetingSubject = meetingSubject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String startingTime) {
        this.time = startingTime;
    }


    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}