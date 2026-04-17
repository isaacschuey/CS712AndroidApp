package com.example.assignment2

import android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo

import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.filters.SdkSuppress
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.textAsString
import androidx.test.uiautomator.uiAutomator

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat

@RunWith(AndroidJUnit4::class)
class UITests {
    @Test
    fun testSecondActivityNavigationAndContent() {
        uiAutomator {
            startApp("com.example.assignment2")
            onElement { textAsString() == "View Mobile SWE Challenges (Explicit)" }.click()
            val challenge = onElementOrNull {
                val text = textAsString()
                val hasChallenge = if (!text.isNullOrEmpty()) text else ""
                hasChallenge.contains("Device Fragmentation") ||
                        hasChallenge.contains("OS Fragmentation") ||
                        hasChallenge.contains("Unstable/Dynamic Environment") ||
                        hasChallenge.contains("Rapid Changes") ||
                        hasChallenge.contains("Low Tolerance")
            }
            assertThat(challenge, notNullValue())
        }
    }
}