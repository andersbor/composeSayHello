package com.example.sayhello

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun sayHelloTest() {
        rule.setContent {
            SayHello()
        }
        //rule.onNodeWithText("Say Hello").performClick()
        rule.onNode(
            hasText("Say Hello")
                    and // infix function
                    hasClickAction()
        ).performClick()
        rule.onNodeWithText("Hello nobody!").assertExists()

        rule.onNodeWithText("Enter your name").performTextInput("Anders")
        rule.onNode(
            hasText("Say Hello")
                    and
                    hasClickAction()
        ).performClick()
        rule.onNodeWithText("Hello Anders!").assertExists()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.sayhello", appContext.packageName)
    }
}