package fr.jaroddeveloppement.mareu;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.JMock1Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import static fr.jaroddeveloppement.mareu.RecyclerViewItemCountAssertion.withItemCount;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import fr.jaroddeveloppement.mareu.di.DI;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.model.Room;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.service.DummySalleGenerator;
import fr.jaroddeveloppement.mareu.ui.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MeetingInstrumentedTest {

    private static final int ITEM_COUNT = 3;
    private static final int MEETING_THE_2022_06_07 =1;
    private static final int MEETING_IN_ROOM = 1;
    ActivityScenario<MainActivity> activity;
    ApiService mApiService;

    @Rule
    public ActivityScenarioRule<MainActivity> mMainActivityActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        activity = mMainActivityActivityScenarioRule.getScenario();
        mApiService = DI.getApiService();
        assertThat(activity, notNullValue());
        activity.recreate();
    }

    @Test
    public void meetingList_isDisplayed() {
        int itemCount = mApiService.getMeeting().size();
        onView(withId(R.id.recyclerViewMeeting)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerViewMeeting)).check(matches(hasMinimumChildCount(itemCount)));
    }
    @Test
    public void myReu_deleteAction_shouldRemoveItem() {
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting)).check(matches(isDisplayed())).check(withItemCount(ITEM_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting)).perform(RecyclerViewActions.actionOnItemAtPosition(1,new DeleteViewAction()));

        onView(ViewMatchers.withId(R.id.recyclerViewMeeting)).check(matches(isDisplayed())).check(withItemCount(ITEM_COUNT-1));

    }
    @Test
    public void ClickOnSaveButtonInAddMeetingActivity_ShouldAddOneMeetingInMaReuActivity() {
        int itemCount = mApiService.getMeeting().size();
        //click on add meeting button
        onView(withId(R.id.buttonAddMeeting))
                .perform(click());
        //check add meeting layout is displayed
        onView(ViewMatchers.withId(R.id.CreationMeeting))
                .check(matches(isDisplayed()));

        //fill the data
        //fill the topic
        onView(ViewMatchers.withId(R.id.sujetMeeting))
                .perform(typeText("Test meeting"))
                .perform(closeSoftKeyboard());

        //click on the spinner to see rooms
        onView(withId(R.id.chooseRoom))
                .perform(click());
        //click on "salle 1"
        onData(allOf(is(instanceOf(Room.class)), is(DummySalleGenerator.DUMMY_SALLE.get(0))))
                .perform(click());
        onView(withId(R.id.buttonDate)).perform(click());
        onView(isAssignableFrom(DatePicker.class)).perform(PickerActions.setDate(2022,5,23));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.buttonTime)).perform(click());
        onView(isAssignableFrom(TimePicker.class)).perform(PickerActions.setTime(7,30));
        onView(withText("OK")).perform(click());

        //set the duration
        onView(ViewMatchers.withId(R.id.SetTime))
                .perform(typeText("2"))
                .perform(closeSoftKeyboard());

        //save
        onView(ViewMatchers.withId(R.id.validationMeeting))
                .perform(click());

        //Meeting list should be displayed with one additional item
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(matches(isDisplayed()))
                .check(withItemCount(itemCount + 1));
    }


    @Test
    public void VerifyMeeting(){
        //click on the menu button
        onView(withId(R.id.menu_meeting_list_activity))
                .perform(click());
        //click on filtre salle
        onView(withText("Filtre Salle"))
                .perform(click());
        //click on salle 1
        onView(withText(DummySalleGenerator.DUMMY_SALLE.get(2).getNomDeLaSalle()))
                .perform(click());
        //Check the number of meetings
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(withItemCount(1));

        onView(withId(R.id.menu_meeting_list_activity))
                .perform(click());
        onView(withText("Annuler les filtres"))
                .perform(click());
    }
    @Test
    public void SelectRoomAsFilter_ShouldShowOnlyMeetingInThisRoom() {
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(matches(isDisplayed()));
        //click on the menu button
        onView(withId(R.id.menu_meeting_list_activity))
                .perform(click());
        //click on filtre salle
        onView(withText("Filtre Salle"))
                .perform(click());
        //click on salle 1
        onView(withText("Toujours au boulot"))
                .perform(click());
        //Check the number of meetings
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(withItemCount(MEETING_IN_ROOM));

        onView(withId(R.id.menu_meeting_list_activity))
                .perform(click());
        onView(withText("Annuler les filtres"))
                .perform(click());
    }

    @Test
    public void SelectDateAsFilter_ShouldShowOnlyMeetingAtThisDate() {
        onView(ViewMatchers.withId(R.id.mainActivity))
                .check(matches(isDisplayed()));
        //click on the menu button
        onView(withId(R.id.menu_meeting_list_activity))
                .perform(click());
        //click on filtre date
        onView(withText("Filtre Date"))
                .perform(click());
        //set the date
        onView(isAssignableFrom(DatePicker.class))
                .perform(PickerActions.setDate(2022, 06, 07));
        //click OK
        onView(withText("OK")).perform(click());
        //check the number of meetings
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(withItemCount(MEETING_THE_2022_06_07));
    }



}
