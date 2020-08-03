package mobile.programming.musicapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.dto.UserData
import mobile.programming.musicapp.ui.main.TestViewModel
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class DtoUnitTest {
    //Nothing to unit test besides instrument data integration and the data classes in the current project state. Firebase doesn't allow unit testing.
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: TestViewModel

    @Test
    internal fun testDataClasses() {
        mvm = TestViewModel()
        createMockData()
    }

    private fun createMockData() {
        val testInstrument = Instrument( 0,"Clarinet", "Percussion", 100)
        //test class function
        testInstrument.toString()

        val list = arrayListOf("piano", "guitar", "drums")
        val userData = UserData("2334534dsfsd5",300.1, list)
        //test class function
        userData.toString()

        //and test if class is real
        assertNotNull(testInstrument)
        assertNotNull(userData)
    }
}
