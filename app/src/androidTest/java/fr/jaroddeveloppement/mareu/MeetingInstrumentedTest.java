package fr.jaroddeveloppement.mareu;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.ContentView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import static fr.jaroddeveloppement.mareu.RecyclerViewItemCountAssertion.withItemCount;



import java.util.List;

import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.ui.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MeetingInstrumentedTest {

    private ActivityScenario mMainActivity;
    private ApiService mApiService;
    private List<Meeting> meetingList;
    private static final int ITEM_COUNT = 2;
    private static final int MEETING_THE_2022_06_07 =1;
    private static final int MEETING_IN_ROOM = 1;


    @Rule
    public ActivityScenarioRule <MainActivity> rule = new ActivityScenarioRule(MainActivity.class);

    @Before
    public void setUp() {
        mMainActivity = rule.getScenario();
        assertThat(rule, notNullValue());

        meetingList = mApiService.getMeeting();
    }

    @Test
    public void ClickOnSaveButtonInAddMeetingActivity_ShouldAddOneMeetingInMaReuActivity() {
        onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
                .check(matches(isDisplayed()));
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
        onData(allOf(is(instanceOf(String.class)), is("Toujours au boulot")))
                .perform(click());

        //set the Date picker
        onView(withId(R.id.buttonDate))
                .perform(PickerActions.setDate(2022, 06, 07));

        //set the Time picker
        onView(withId(R.id.buttonTime))
                .perform(PickerActions.setTime(9, 15));

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
                .check(withItemCount(ITEM_COUNT + 1));




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
    onView(withText("Toujours au boulot"))
            .perform(click());
    //Check the number of meetings
    onView(ViewMatchers.withId(R.id.recyclerViewMeeting))
           .check(withItemCount(2));
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
        onView(ViewMatchers.withId(R.id.mainActivity))
                .check(withItemCount(MEETING_THE_2022_06_07));
    }

    @Test
    public void myReu_deleteAction_shouldRemoveItem() {

        onView(ViewMatchers.withId(R.id.mainActivity)).check(matches(isDisplayed())).check(withItemCount(ITEM_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.mainActivity)).perform(RecyclerViewActions.actionOnItemAtPosition(1,new DeleteViewAction()));

        onView(ViewMatchers.withId(R.id.mainActivity)).check(matches(isDisplayed())).check(withItemCount(ITEM_COUNT-1));
    }

}