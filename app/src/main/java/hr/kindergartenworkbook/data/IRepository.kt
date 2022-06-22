package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Category
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.model.User

interface IRepository {
    fun login(userName: String, password: String): User
    fun getCategories(): List<Category>
    fun getActivities(groupId: Int, date: String): List<Activity>
    fun getChildren(groupId: Int, activityId: Int): List<Child>
    fun saveObservation(children: List<Child>): Boolean
}