package di.playground.core.data


interface DrinksRepository {

    fun getDrink(): String
}

class DrinksRepositoryImpl : DrinksRepository {

    private val drink =
        listOf("milk", "juice", "beer", "rum", "water").random() + (0..100).random()

    override fun getDrink(): String {
        return drink
    }
}