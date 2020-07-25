package mobile.programming.musicapp.dao

import mobile.programming.musicapp.dto.Instrument
import retrofit2.Call
import retrofit2.http.GET

interface MusicAppDAO {
    /** https://jsonkeeper.com/b/JGH1
     *json to be updated in the future with planned instruments
     * Gets the list of instruments through retrofit
     *
     */
    @GET("/b/JGH1")
    fun getAllInstruments(): Call<ArrayList<Instrument>>
}