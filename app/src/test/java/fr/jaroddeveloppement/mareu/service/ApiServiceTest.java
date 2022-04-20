package fr.jaroddeveloppement.mareu.service;


import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;


import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.model.Users;


@RunWith(JUnit4.class)
public class ApiServiceTest {


    private ApiService mApiServcie;

    @Before
    public void setup() {
        mApiServcie = DI.getNewInstanceApiService();
    }



    @Test
    public void testGetUser() {
        List<Users> mGetUser = mApiServcie.getUser();
        List<Users>expectedUsers = DummyUtilisateurGenerator.dummyUsers;
        org.hamcrest.MatcherAssert.assertThat(mGetUser, IsIterableContainingInAnyOrder.containsInAnyOrder (expectedUsers.toArray()));

    }
    @Test
    public void testGetRoom() {

        List<Room> mGetRoom = mApiServcie.getRoom();
        List<Room>expectedRoom = DummySalleGenerator.DUMMY_SALLE;
        org.hamcrest.MatcherAssert.assertThat(mGetRoom, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedRoom.toArray()));
    }

    @Test
    public void testGetMeeting() {

        //TODO creer deux objets meeting et verifier le size de la liste

        List<Meeting> mGetMeeting = mApiServcie.getMeeting();
        //List<Meeting> expectedMeeting = DummyApiService.ArrayList<Meeting>;
       // assertThat(mGetMeeting, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeeting.toArray()));
    }

    @Test
    public void testAddMeeting() {

        //todo creer un meeting
    }

    @Test
    public void testRemoveMetting() {
        //todo  creer un meeting + delete
    }

    @Test
    public void testFilterByRoom() {
        //todo creer un meeting et le filtrer par Room
    }

    @Test
    public void testFilterByDate() {

        //todo creer un meeting et le filtrer par Date
    }
}