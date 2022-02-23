package fr.jaroddeveloppement.mareu.model;

public class Room {

   /** Identifier*/
    private long id;

    /** Name Show Room */
    private String nomDeLaSalle;



    /**
     * Constructor
     * @param id
     * @param nomDeLaSalle
     */
    public Room(long id, String nomDeLaSalle) {
        this.id = id;
        this.nomDeLaSalle = nomDeLaSalle;
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
