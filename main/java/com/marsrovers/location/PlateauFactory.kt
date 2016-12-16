package com.marsrovers.location

class PlateauFactory {

    fun createDefaultPlateau(): Plateau = Plateau(DEFAULT_HORIZONTAL_SIZE, DEFAULT_VERTICAL_SIZE)

    companion object {

        private val DEFAULT_HORIZONTAL_SIZE = 10
        private val DEFAULT_VERTICAL_SIZE = 10
    }

}
