package fr.jaroddeveloppement.mareu.event;

import fr.jaroddeveloppement.mareu.model.Users;

public class GetUserEvent {

    public Users  mUsers;
    public GetUserEvent(Users mUsers){this.mUsers = mUsers;}
}
