package com.booster.investortypescheck.view;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.booster.investortypescheck.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AutomationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void automationTest() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.action_menu), withContentDescription("MENU"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.left_drawer),
                        childAtPosition(
                                withId(R.id.drawer),
                                1)))
                .atPosition(0);
        linearLayout.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.action_menu), withContentDescription("MENU"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.question_bt), withText("QUESTIONNAIRE"),
                        childAtPosition(
                                allOf(withId(R.id.drawer),
                                        childAtPosition(
                                                withId(R.id.drawer_layout),
                                                1)),
                                2),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withText("Within 2 years � you need a DEFENSIVE TYPE fund"),
                        childAtPosition(
                                allOf(withId(R.id.answer_layout),
                                        childAtPosition(
                                                withId(R.id.question_layout),
                                                2)),
                                0),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.next_bt), withText("NEXT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withText("I want to minimise my risk and am therefore willing to accept low returns"),
                        childAtPosition(
                                allOf(withId(R.id.answer_layout),
                                        childAtPosition(
                                                withId(R.id.question_layout),
                                                2)),
                                0),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.next_bt), withText("NEXT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
                allOf(withText("Strongly Agree"),
                        childAtPosition(
                                allOf(withId(R.id.answer_layout),
                                        childAtPosition(
                                                withId(R.id.question_layout),
                                                2)),
                                0),
                        isDisplayed()));
        button6.perform(click());

        ViewInteraction button7 = onView(
                allOf(withId(R.id.next_bt), withText("NEXT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button7.perform(click());

        ViewInteraction button8 = onView(
                allOf(withText("I would be unhappy with any drop in value"),
                        childAtPosition(
                                allOf(withId(R.id.answer_layout),
                                        childAtPosition(
                                                withId(R.id.question_layout),
                                                2)),
                                0),
                        isDisplayed()));
        button8.perform(click());

        ViewInteraction button9 = onView(
                allOf(withId(R.id.next_bt), withText("NEXT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button9.perform(click());

        ViewInteraction button10 = onView(
                allOf(withText("Daily"),
                        childAtPosition(
                                allOf(withId(R.id.answer_layout),
                                        childAtPosition(
                                                withId(R.id.question_layout),
                                                2)),
                                0),
                        isDisplayed()));
        button10.perform(click());

        ViewInteraction button11 = onView(
                allOf(withId(R.id.next_bt), withText("NEXT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button11.perform(click());

        ViewInteraction button12 = onView(
                allOf(withId(R.id.next_bt), withText("SHOW"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button12.perform(click());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.action_menu), withContentDescription("MENU"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction button13 = onView(
                allOf(withId(R.id.submit_bt), withText("SUBMIT"),
                        childAtPosition(
                                allOf(withId(R.id.drawer),
                                        childAtPosition(
                                                withId(R.id.drawer_layout),
                                                1)),
                                3),
                        isDisplayed()));
        button13.perform(click());

        pressBack();

        pressBack();

        ViewInteraction button14 = onView(
                allOf(withId(R.id.submit_bt), withText("SUBMIT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button14.perform(click());

        ViewInteraction button15 = onView(
                allOf(withId(R.id.comfirm_bt), withText("CONFRIM"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_container),
                                        0),
                                1),
                        isDisplayed()));
        button15.perform(click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
