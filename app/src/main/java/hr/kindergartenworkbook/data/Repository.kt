package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Category
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.model.User

class Repository : IRepository {

    override fun getCategories(): List<Category> {
        return listOf(
            Category(1, "Category 1", "code 1"),
            Category(2, "Category 2", "code 2"),
            Category(3, "Category 3", "code 3"),
            Category(4, "Category 4", "code 4")
        )
    }

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
        TODO("Not yet implemented")
    }

    override fun saveObservation(children: List<Child>) {
        TODO("Not yet implemented")
    }

}