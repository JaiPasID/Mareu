package fr.jaroddeveloppement.mareu.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        List<Meeting> mMeeting =mApiServcie.getMeeting();
        List<Meeting>expectedMeetingList = DummyMeetingTest.DUMMY_METING_TEST;
        org.hamcrest.MatcherAssert.assertThat(mMeeting, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetingList.toArray()));

    }

    @Test
    public void testAddMeeting() {

        Meeting meeting = new Meeting(DummyUtilisateurGenerator.dummyUsers, DummySalleGenerator.DUMMY_SALLE.get(5), "2022,05,05", "08,15","Test rendez vous");
        assertFalse(mApiServcie.getMeeting().contains(meeting));
        mApiServcie.addMeeting(meeting);
        assertTrue(mApiServcie.getMeeting().contains(meeting));
    }

    @Test
    public void testRemoveMetting() {
        Meeting mMeeting = mApiServcie.getMeeting().get(0);
        assertTrue(mApiServcie.getMeeting().contains(mMeeting));
        mApiServcie.removeMetting(mMeeting);
        assertFalse(mApiServcie.getMeeting().contains(mMeeting));
    }

    @Test
    public void testFilterByRoom() {
        Meeting mMeeting = mApiServcie.getMeeting().get(0);
        List<Meeting> originalMeetingList = mApiServcie.getMeeting();
        assertTrue(originalMeetingList.size() > 1);
        List<Meeting> filteredMeetingList = mApiServcie.filterByRoom(mMeeting.getRoom());
        assertTrue(filteredMeetingList.contains(mMeeting));
        assertEquals(1, filteredMeetingList.size());
    }

    @Test
    public void testFilterByDate() {
        Meeting mMeeting = mApiServcie.getMeeting().get(0);
        List<Meeting> originalMeetingList = mApiServcie.getMeeting();
        assertTrue(originalMeetingList.size() > 1);
        List<Meeting> filteredMeetingList = mApiServcie.filterByDate(mMeeting.getDate());
        assertTrue(filteredMeetingList.contains(mMeeting));
        assertEquals(1, filteredMeetingList.size());
    }
}