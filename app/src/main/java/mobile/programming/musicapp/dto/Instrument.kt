package mobile.programming.musicapp.dto

data class Instrument(var id: Int, var name: String, var type: String) {

    override fun toString(): String{
        return "$id $name $type"
    }
}