package mobile.programming.musicApp.service

import androidx.lifecycle.MutableLiveData
import mobile.programming.musicApp.RetrofitClientInstance
import mobile.programming.musicApp.dao.MusicAppDAO
import mobile.programming.musicApp.dto.Instrument
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstrumentService {
    internal fun fetchInstruments(): MutableLiveData<ArrayList<Instrument>> {
        val _instruments = MutableLiveData<ArrayList<Instrument>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(
            MusicAppDAO::class.java)
        val call = service?.getAllInstruments()
        call?.enqueue(object : Callback<ArrayList<Instrument>> {

            override fun onFailure(call: Call<ArrayList<Instrument>>, t: Throwable) {
                //log here
            }

            override fun onResponse(
                call: Call<ArrayList<Instrument>>,
                response: Response<ArrayList<Instrument>>
            ){
                _instruments.value = response.body()

                print(response.body())
            }
        })
        return _instruments
    }
}