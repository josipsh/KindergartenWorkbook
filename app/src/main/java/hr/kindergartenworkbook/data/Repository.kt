package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.data.dtos.LoginRequestDto
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.model.User
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class Repository : IRepository {
    private var userData: User? = null
    private var authToken: String = ""
    private var retrofit: DataRestApiInterface = Retrofit.Builder()
        .baseUrl(DataRestApiInterface.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DataRestApiInterface::class.java)


    override suspend fun getActivities(groupId: Int, date: String): List<Activity> {
        val response = retrofit.getActivities(authToken, groupId, "2022-06-26").awaitResponse()

        if (response.isSuccessful) {
            response.body()?.let {
                return it.map { c -> c.toModel() }
            } ?: run { throw Exception("Unexpected error") }
        } else {
            throw Exception("${response.code()}")
        }
    }

    override suspend fun getChildren(groupId: Int, activityId: Int): List<Child> {
        val response = retrofit.getChildren(authToken, groupId).awaitResponse()

        if (response.isSuccessful) {
            response.body()?.let {
                return it.map { c -> c.toModel() }
            } ?: run { throw Exception("Unexpected error") }
        } else {
            throw Exception("${response.code()}")
        }
    }

    override suspend fun login(userName: String, password: String): User {
        getUserData(userName, password)
        getGroupName()
        return userData ?: run { throw Exception("Unexpected error") }
    }

    override suspend fun getUser(): User {
        userData?.let {
            return it
        } ?: run { throw  Exception("Unexpected error") }
    }

    override suspend fun saveObservation(children: List<Child>): Boolean {
        return true
    }

    private fun getUserData(userName: String, password: String) {
        val response = retrofit.login(LoginRequestDto(userName, password)).execute()

        if (response.isSuccessful) {
            response.body()?.let {
                userData = User(it.User.Id, it.User.GroupId, "")
                authToken = "Bearer ${it.Token}"
            }
        } else {
            throw Exception("${response.code()}")
        }
    }

    private fun getGroupName() {
        userData?.groupId?.let {
            val response = retrofit.getGroup(authToken, it).execute()

            if (response.isSuccessful) {
                response.body()?.let {
                    userData?.let { user ->
                        user.groupName = it.Name
                    }
                }
            } else {
                throw Exception("${response.code()}")
            }
        }
    }
}