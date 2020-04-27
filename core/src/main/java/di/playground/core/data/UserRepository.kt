package di.playground.core.data

import tk.zielony.randomdata.RandomData
import tk.zielony.randomdata.annotation.RandomValue
import tk.zielony.randomdata.common.LongIdGenerator
import tk.zielony.randomdata.person.Gender
import tk.zielony.randomdata.person.StringGenderGenerator
import tk.zielony.randomdata.person.StringNameGenerator
import tk.zielony.randomdata.person.StringPhoneGenerator
import tk.zielony.randomdata.place.StringCityGenerator
import java.io.Serializable


interface UserRepository {

    fun fetchUsers(): List<User>

    fun addUser(user: User)

    fun removeUser(user: User)

    fun getUser(id: Long): User
}

object UserRepositoryImpl : UserRepository {

    private val users = mutableListOf<User>()

    init {
        val randomData = RandomData()
        randomData.addGenerator(String::class.java, StringNameGenerator(Gender.Both))
        randomData.addGenerator(String::class.java, StringCityGenerator())
        randomData.addGenerator(String::class.java, StringPhoneGenerator())
        randomData.addGenerator(String::class.java, StringGenderGenerator())
        randomData.addGenerator(Long::class.java, LongIdGenerator())
        for (i in 0..5) {
            users.add(randomData.generate(User::class.java))
        }
    }

    override fun fetchUsers(): List<User> {
        return users
    }

    override fun addUser(user: User) {
        users.add(user)
    }

    override fun removeUser(user: User) {
        users.remove(user)
    }

    override fun getUser(id: Long): User {
        return users.find { it.id == id } ?: throw NoSuchElementException()
    }

}

data class User(
    @RandomValue(name = "id")
    val id: Long,
    @RandomValue(name = "name")
    val name: String,
    @RandomValue(name = "phone")
    val phone: String,
    @RandomValue(name = "city")
    val city: String,
    @RandomValue(name = "gender")
    val gender: String
) : Serializable