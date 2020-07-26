package mobile.programming.musicapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.service.InstrumentService
import mobile.programming.musicapp.ui.main.MainViewModel
import io.mockk.mockk
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

class InstrumentDataIntegrationTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit private var mvm: MainViewModel
    private var instrumentService = mockk<InstrumentService>()

    @Test
    internal fun TestInstrumentListForResults() {
        givenAFeedOfInstrumentDataAreAvailable()
        getAllTheInstruments()
        checkIfInstrumentDataIsEmpty()
    }

    private fun givenAFeedOfInstrumentDataAreAvailable() {
        mvm = MainViewModel()
    }

    private fun getAllTheInstruments() {
        mvm.getAllInstruments()
    }

    private fun checkIfInstrumentDataIsEmpty() {
        var instrumentList = ArrayList<Instrument>()
        mvm.instruments.observeForever {
            instrumentList = it
        }
        Thread.sleep(5000)
        assertNotNull(instrumentList)
        assertTrue(instrumentList.size > 0)
    }
}
