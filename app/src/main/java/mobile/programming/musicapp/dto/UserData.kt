package mobile.programming.musicapp.dto


data class UserData(var id: String, var money: Double, var unlockedInstruments: ArrayList<String>) {

    override fun toString(): String{

        return "$id $money $unlockedInstruments"
    }

}