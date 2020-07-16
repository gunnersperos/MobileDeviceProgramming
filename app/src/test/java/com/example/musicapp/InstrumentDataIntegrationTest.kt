package com.example.musicapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicapp.dto.Instrument
import com.example.musicapp.service.InstrumentService
import com.example.musicapp.ui.main.MainViewModel
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

class InstrumentDataIntegrationTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel
    var instrumentService = mockk<InstrumentService>()

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
        mvm.instruments.observeForever {
            assertNotNull(it)
            assertEquals(4, it.size)
        }
    }
}
