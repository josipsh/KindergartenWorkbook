package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Category
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.model.User

class Repository : IRepository {

    override fun getCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override fun getActivities(groupId: Int, date: String): List<Activity> {
        TODO("Not yet implemented")
    }

    override fun getChildren(groupId: Int, activityId: Int): List<Child> {
        TODO("Not yet implemented")
    }

    override fun login(userName: String, password: String): User {
        TODO("Not yet implemented")
    }

    override fun saveObservation(children: List<Child>) {
        TODO("Not yet implemented")
    }

}