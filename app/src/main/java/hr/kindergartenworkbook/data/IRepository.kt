package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.model.*
import java.util.*

interface IRepository {
    suspend fun login(userName: String, password: String): User
    suspend fun getUser(): User
    suspend fun getActivities(date: Date): List<Activity>
    suspend fun getChildren(activityId: Int): List<Child>
    suspend fun saveObservation(activity: Activity, children: List<Child>, date: Date): Boolean
}