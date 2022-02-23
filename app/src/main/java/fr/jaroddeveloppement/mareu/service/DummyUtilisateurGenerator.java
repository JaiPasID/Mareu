package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Utilisateur;


// pourquoi faire une class abstract?
public  class DummyUtilisateurGenerator {

  public static List<Utilisateur> DUMMY_UTILISATEUR = Arrays.asList(

          new Utilisateur("Labiche", "Michael", "Vente", "m.labiche@lamzone.com"),
          new Utilisateur("Lachevre", "Micehlle", "Comptabilité", "m.lachevre@lamzone.com"),
          new Utilisateur("Lours", "Morgan", "Ressource Humaine", "m.lours@lamzone.com"),
          new Utilisateur("Lapoule", "Micheline", "Marketing", "m.lapoule@lamzone.com"),
          new Utilisateur("Lavie","Maurice", "CEO","m.lavie@lamzone.com")
    );

  static List<Utilisateur> ListUtilisateur() {return  new ArrayList<>(DUMMY_UTILISATEUR); }

}
