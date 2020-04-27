package di.playground.core.data


interface AnimalRepository {

    fun getAnimal(): String
}

class AnimalRepositoryImpl : AnimalRepository {

    private val animal = listOf(
        "cat",
        "dog",
        "chicken",
        "koala",
        "panda",
        "barsuk",
        "deer",
        "monkey",
        "cow",
        "goat",
        "goose",
        "horse",
        "rabbit",
        "lama",
        "alpaca"
    ).random() + (0..100).random()

    override fun getAnimal(): String {
        return animal
    }
}