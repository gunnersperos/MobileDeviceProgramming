package mobile.programming.musicapp.dto

/**
 * User Data
 *
 * @param UserData.id Unique identifier for each user
 * @param UserData.money Users money in the game
 * @param UserData.unlockedInstruments Array list of every instrument the user has bought in the store
 */

data class UserData(var id: String, var money: Double, var unlockedInstruments: ArrayList<String>) {

    override fun toString(): String {

        return "$id $money $unlockedInstruments"
    }

}