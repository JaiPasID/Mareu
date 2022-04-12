package fr.jaroddeveloppement.mareu.event;

import fr.jaroddeveloppement.mareu.model.Room;

public class GetRoomEvent {

    public Room mRoom;

    public GetRoomEvent(Room mRoom) {
        this.mRoom = mRoom;
    }
}
