package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Users;



public abstract class DummyUtilisateurGenerator {

  public static List<Users> dummyUsers = Arrays.asList(

          new Users("Labiche", "Michael", "Vente", "m.labiche@lamzone.com"),
          new Users("Lachevre", "Micehlle", "Comptabilité", "m.lachevre@lamzone.com"),
          new Users("Lours", "Morgan", "Ressource Humaine", "m.lours@lamzone.com"),
          new Users("Lapoule", "Micheline", "Marketing", "m.lapoule@lamzone.com"),
          new Users("Lavie","Maurice", "CEO","m.lavie@lamzone.com")
    );

  static List<Users> listUser() {return  new ArrayList<>(dummyUsers); }

}