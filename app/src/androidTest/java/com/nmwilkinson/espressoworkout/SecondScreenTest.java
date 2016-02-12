package com.nmwilkinson.espressoworkout;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by neil on 11/02/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SecondScreenTest {
    public static final String TEST_VALUE = "TEST VALUE";
    @Rule
    public ActivityTestRule<SecondActivity> mainActivityActivityTestRule = new ActivityTestRule<SecondActivity>(SecondActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            final Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            return SecondActivity.createLaunchIntent(targetContext, TEST_VALUE);
        }
    };

    @Test
    public void valueDisplayed() {
        onView(withId(R.id.display_selected_item)).check(matches(withText(TEST_VALUE)));
    }
}
