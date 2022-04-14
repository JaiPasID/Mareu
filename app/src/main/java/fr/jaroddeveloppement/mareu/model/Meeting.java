package fr.jaroddeveloppement.mareu.model;


public class Meeting {

    Users users;
    Room room;

    private String date;
    private String time;
    private String meetingSubject;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Constructor
     *
     * @param users
     * @param room
     * @param date
     * @param time
     * @param meetingSubject
     */


    public Meeting(Users users, Room room, String date, String time, String meetingSubject) {
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

    public String getStartingTime() {
        return time;
    }

    public void setStartingTime(String startingTime) {
        this.time = startingTime;
    }


    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }
}