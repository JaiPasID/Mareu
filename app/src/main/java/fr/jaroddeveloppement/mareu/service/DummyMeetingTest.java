package fr.jaroddeveloppement.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.jaroddeveloppement.mareu.model.Meeting;


public class DummyMeetingTest {

    public static List<Meeting> DUMMY_METING_TEST = Arrays.asList(

           new Meeting(DummyUtilisateurGenerator.dummyUsers, DummySalleGenerator.DUMMY_SALLE.get(2), "2022/04/30", "15:10","Test1"),
            new Meeting(DummyUtilisateurGenerator.dummyUsers, DummySalleGenerator.DUMMY_SALLE.get(3), "2022/05/15", "15:50","Test2"),
            new Meeting(DummyUtilisateurGenerator.dummyUsers, DummySalleGenerator.DUMMY_SALLE.get(4), "2022/06/07", "14:25","Test3")
    );

    static List<Meeting> listMeetingTest() {
        return new ArrayList<>(DUMMY_METING_TEST);
    }


}
