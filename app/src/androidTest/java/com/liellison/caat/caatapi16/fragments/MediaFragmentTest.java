package com.liellison.caat.caatapi16.fragments;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MediaFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mediaFragmentTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withText("Materias"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatSpinner = onView(
                withId(R.id.spinnerPrimeiroP));
        appCompatSpinner.perform(scrollTo(), click());

    }

}
