package mobile.programming.musicapp.dto

/**
 * Instrument information
 *
 * @param Instrument.id Unique identifier for each instruments
 * @param Instrument.name Name of instrument
 * @param Instrument.type Type of instrument. Ex: String, Percussion, etc.
 * @param Instrument.price Price of instrument for the store UI
 */

data class Instrument(var id: Int, var name: String, var type: String, var price: Int) {

    override fun toString(): String {

        return "$id $name $type $price"
    }

}