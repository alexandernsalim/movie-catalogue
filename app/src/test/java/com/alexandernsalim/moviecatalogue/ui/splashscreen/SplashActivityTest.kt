package com.alexandernsalim.moviecatalogue.ui.splashscreen

import android.os.Build
import com.alexandernsalim.moviecatalogue.ui.home.HomeActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
@Config(maxSdk = Build.VERSION_CODES.P, minSdk = Build.VERSION_CODES.P)
class SplashActivityTest {

    @Test
    fun shouldStartHomeActivityAfterSomeDelay() {
        val activity = Robolectric.buildActivity(SplashActivity::class.java)
            .create()
            .resume()
            .get()

        assertNotNull(activity)
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()

        val actual = shadowOf(activity).nextStartedActivity.component?.className
        val expected = HomeActivity::class.java.canonicalName

        assertEquals(expected, actual)
    }
}