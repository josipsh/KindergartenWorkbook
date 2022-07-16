package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.*

interface IRepository {
    fun login(userName: String, password: String): User
    fun getUser(): User
    fun getActivities(groupId: Int, date: String): List<Activity>
    fun getChildren(groupId: Int, activityId: Int): List<Child>
    fun saveObservation(children: List<Child>): Boolean
}