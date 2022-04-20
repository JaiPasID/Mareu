package fr.jaroddeveloppement.mareu;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.jaroddeveloppement.mareu.dialogFragment.DatePickerFragment;
import fr.jaroddeveloppement.mareu.model.Meeting;
import fr.jaroddeveloppement.mareu.ui.MainActivity;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingInstrumentedTest {

    private ActivityScenario mMainActivity;

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        mMainActivity = rule.getScenario();
        assertThat(rule, notNullValue());
    }


    @Test
    public void AddMeetingTest(){

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddMeeting)).perform(click());
        onView(withId(R.id.buttonDate)).perform(PickerActions.setDate(2022,04,30) );
        onView(withId(R.id.buttonTime)).perform(PickerActions.setTime(5,15));
         // TODO onView(withId(R.id.buttonUser)).perform(//mettre la liste des Users je pense);
        // TODO onView(withId(R.id.chooseRoom)).perform(//mettre la liste des Room je pense);
      //  onView(withId(R.id.sujetMeeting)).perform(editT)
    }
    // todo faire un seul test comprenant création du meeting filtre room clear filtre date et supprimer ou faire un test pour chaque étape ?
}