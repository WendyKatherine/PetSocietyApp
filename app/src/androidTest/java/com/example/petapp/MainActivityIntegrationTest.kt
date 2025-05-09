package com.example.petapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityIntegrationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun perfilButton_showsProfileInfo() {
        onView(withId(R.id.btnPerfil)).perform(click())

        onView(withId(R.id.txtPerfilNombre))
            .check(matches(isDisplayed()))
            .check(matches(withText("🐾 Tabata Nala")))
    }
}
