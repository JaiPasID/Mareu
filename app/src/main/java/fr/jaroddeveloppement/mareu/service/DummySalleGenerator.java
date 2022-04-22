package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Room;


public abstract class DummySalleGenerator {

    public static List<Room> DUMMY_SALLE = Arrays.asList(

            new Room(0,"Choisir une salle", android.R.color.white),
            new Room(1, "Petite Fleur", android.R.color.black),
            new Room(2, "Afk", android.R.color.holo_green_light),
            new Room(3, "Toujours au boulot", android.R.color.holo_red_light),
            new Room(4, "Salle des maîtres", android.R.color.holo_blue_light),
            new Room(5, "Salle des esclaves", android.R.color.holo_green_dark),
            new Room(6, "Salle de Zirkonya", android.R.color.holo_orange_dark),
            new Room(7, "Salle de torture", android.R.color.holo_red_dark),
            new Room(8, "Salle des planqués", android.R.color.darker_gray),
            new Room(9, "Salle des lèches bottes", android.R.color.holo_purple),
            new Room(10, "Salle du vendredi soir", android.R.color.holo_blue_dark)
    );

    static List<Room> listSalle() {
        return new ArrayList<>(DUMMY_SALLE);
    }

}