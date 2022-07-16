package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Category
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.model.User

class Repository : IRepository {
    private var userData: User? = User(1, 1, "Jabukice")

    override fun getActivities(groupId: Int, date: String): List<Activity> {
        return listOf(
            Activity(1, "Activity 1"),
            Activity(2, "Activity 2"),
            Activity(3, "Activity 3"),
            Activity(4, "Activity 4"),
            Activity(5, "Activity 5"),
            Activity(6, "Activity 6"),
        )
    }

    override fun getChildren(groupId: Int, activityId: Int): List<Child> {
        return listOf(
            Child(1, activityId, "Pero", "Peric", 0, "This is note"),
            Child(2, activityId, "Lea", "Leic", 1, "This is note"),
            Child(3, activityId, "Marko", "Maric", 2, "This is note"),
        )
    }

    override fun login(userName: String, password: String): User {
        //throw Exception("Invalid username or password")
        return User(1, 1, "Jabikice")
    }

    override fun getUser(): User {
        userData?.let {
            return it
        } ?: run { throw  Exception() }
    }

    override fun saveObservation(children: List<Child>): Boolean {
        return true
    }

}