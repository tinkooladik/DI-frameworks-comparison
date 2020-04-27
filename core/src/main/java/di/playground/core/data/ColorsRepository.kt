package di.playground.core.data

import android.graphics.Color.*


interface ColorsRepository {

    fun getColor(): Int
}

object ColorRepositoryImpl : ColorsRepository {

    private val colors = listOf(BLUE, YELLOW, CYAN, MAGENTA, RED, GREEN, GRAY)

    override fun getColor(): Int {
        return colors.random()
    }
}