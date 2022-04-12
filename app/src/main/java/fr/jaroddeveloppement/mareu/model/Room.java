package fr.jaroddeveloppement.mareu.model;

public class Room {

   /** Identifier*/
    private long id;

    /** Name Show Room */
    private String nomDeLaSalle;

    private int colorRoom;



    /**
     * Constructor
     * @param id
     * @param nomDeLaSalle
     */
    public Room(long id, String nomDeLaSalle, int colorRoom) {
        this.id = id;
        this.nomDeLaSalle = nomDeLaSalle;
        this.colorRoom = colorRoom;
    }

    public int getColorRoom() {
        return colorRoom;
    }

    public void setColorRoom(int colorRoom) {
        this.colorRoom = colorRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomDeLaSalle() {
        return nomDeLaSalle;
    }

    public void setNomDeLaSalle(String nomDeLaSalle) {
        this.nomDeLaSalle = nomDeLaSalle;
    }





}