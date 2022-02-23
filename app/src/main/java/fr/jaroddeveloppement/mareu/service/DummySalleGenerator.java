package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Room;


public  class DummySalleGenerator {

public static List<Room> DUMMY_SALLE = Arrays.asList(

        new Room(1, "Petite Fleur"),
        new Room(2, "Afk"),
        new Room(3 , "Toujours au boulot"),
        new Room(4, "Salle des maîtres"),
        new Room(5, "Salle des esclaves"),
        new Room(6, "Salle de Zirkonya"),
        new Room(7, "Salle de torture"),
        new Room(8, "Salle des planqués"),
        new Room(9, "Salle des lèches bottes" ),
        new Room (10, "Salle du vendredi soir")
);

  static List<Room> ListSalle(){ return new ArrayList<>(DUMMY_SALLE);}

}
