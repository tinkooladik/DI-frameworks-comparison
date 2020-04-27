package di.playground.core.data


interface PlanetsRepository {

    fun getPlanet(): String
}

class PlanetRepositoryImpl : PlanetsRepository {

    private val planet =
        listOf(
            "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune"
        ).random() + (0..100).random()

    override fun getPlanet(): String {
        return planet
    }
}