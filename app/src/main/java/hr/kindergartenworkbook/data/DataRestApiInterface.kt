package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.data.dtos.ObservationRequestDto
import hr.kindergartenworkbook.data.dtos.UserLoginRequest
import retrofit2.Call
import retrofit2.http.*

interface DataRestApiInterface {
    @GET("/api/children/{groupId}")
    fun getChildren(
        @Header("Authorization") authToken: String,
        @Query("groupId") groupId: Int): Call<String>

    @GET("/api/activities/{groupId}/{date}")
    fun getActivities(
        @Header("Authorization") authToken: String,
        groupId: Int,
        date: String): Call<String>

    @POST("/api/account/login")
    fun login(@Body userData: UserLoginRequest): Call<String>

    @POST("/api/observation")
    fun saveObservation(
        @Header("Authorization") authToken: String,
        @Body observationData: ObservationRequestDto): Call<String>
}