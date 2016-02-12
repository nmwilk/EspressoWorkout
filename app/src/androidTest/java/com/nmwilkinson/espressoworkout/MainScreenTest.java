package com.nmwilkinson.espressoworkout;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by neil on 11/02/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void itemSelection() {
        onView(withId(R.id.selected_item)).check(matches(isDisplayed()));
        onView(withId(R.id.selected_item)).check(matches(withText("")));

        onView(withId(R.id.button)).check(matches(not(isDisplayed())));

        onView(withId(R.id.list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withId(R.id.selected_item)).check(matches(withText("Do to the Beast")));
    }

    @Test
    public void itemClear() {
        itemSelection();

        onView(withId(R.id.selected_item)).perform(longClick());
        onView(withId(R.id.selected_item)).check(matches(withText("")));
        onView(withId(R.id.button)).check(matches(not(isDisplayed())));
    }
}
