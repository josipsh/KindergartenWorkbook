package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.data.dtos.ActivityReadDto
import hr.kindergartenworkbook.data.dtos.ChildReadDto
import hr.kindergartenworkbook.data.dtos.LoginRequestDto
import hr.kindergartenworkbook.data.dtos.LoginResponseDto
import retrofit2.Call
import retrofit2.http.*

interface DataRestApiInterface {
    @GET("/api/Children/GetChildrenByGroup/{groupId}")
    fun getChildren(
        @Header("Authorization") authToken: String,
        @Query("groupId") groupId: Int): Call<List<ChildReadDto>>

    @GET("/api/activities/{groupId}/{date}")
    fun getActivities(
        @Header("Authorization") authToken: String,
        groupId: Int,
        date: String): Call<List<ActivityReadDto>>

    @POST("/api/account/login")
    fun login(@Body userData: LoginRequestDto): Call<LoginResponseDto>

    @POST("/api/observation")
    fun saveObservation(
        @Header("Authorization") authToken: String,
        @Body observationData: LoginRequestDto): Call<String>
}