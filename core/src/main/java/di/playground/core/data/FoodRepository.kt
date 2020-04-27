package di.playground.core.data


interface FoodRepository {

    fun getFood(): String
}

class FoodRepositoryImpl : FoodRepository {

    private val food =
        listOf("meat", "bread", "okroshka", "salad", "potato").random() + (0..100).random()

    override fun getFood(): String {
        return food
    }
}