package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.*

interface IRepository {
    suspend fun login(userName: String, password: String): User
    suspend fun getUser(): User
    suspend fun getActivities(groupId: Int, date: String): List<Activity>
    suspend fun getChildren(groupId: Int, activityId: Int): List<Child>
    suspend fun saveObservation(children: List<Child>): Boolean
}