package fr.jaroddeveloppement.mareu;

import fr.jaroddeveloppement.mareu.model.Meeting;

public class DeleteEvent {


    public Meeting meeting;

    public DeleteEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}
