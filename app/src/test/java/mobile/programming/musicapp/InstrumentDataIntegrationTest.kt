package mobile.programming.musicapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.ui.main.TestViewModel
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class InstrumentDataIntegrationTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: TestViewModel

    @Test
    internal fun TestInstrumentListForResults() {
        givenAFeedOfInstrumentDataAreAvailable()
        getAllTheInstruments()
        checkIfInstrumentDataIsEmpty()
    }

    private fun givenAFeedOfInstrumentDataAreAvailable() {
        mvm = TestViewModel()
    }

    private fun getAllTheInstruments() {
        mvm.getAllInstruments()
    }

    private fun checkIfInstrumentDataIsEmpty() {
        var instrumentlist = ArrayList<Instrument>()
        mvm.instruments.observeForever {

            instrumentlist = it
        }

        Thread.sleep(5000)
        assertNotNull(instrumentlist)
        assertTrue(instrumentlist.size > 0)
    }
}
