package fr.jaroddeveloppement.mareu.model;


public class Meeting  {

    Utilisateur utilisateur;
    Room room;

    public Meeting(Utilisateur utilisateur, Room room) {
        this.utilisateur = utilisateur;
        this.room = room;
    }
}
