package fr.jaroddeveloppement.mareu.model;


public class Meeting {

    Users users;
    Room room;

    private String date;
    private String startingTime;
    private String endTime;
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
     * @param startingTime
     * @param endTime
     * @param meetingSubject
     */


    public Meeting(Users users, Room room, String date, String startingTime, String endTime, String meetingSubject) {
        this.users = users;
        this.room = room;
        this.date = date;
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.meetingSubject = meetingSubject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }
}