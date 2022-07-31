package hr.kindergartenworkbook.data

import hr.kindergartenworkbook.data.dtos.*
import retrofit2.Call
import retrofit2.http.*

interface DataRestApiInterface {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("/api/Children/GetChildrenByGroup/{groupId}")
    fun getChildren(
        @Header("Authorization") authToken: String,
        @Path("groupId") groupId: Int
    ): Call<List<ChildReadDto>>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("/api/activities/{groupId}/{date}")
    fun getActivities(
        @Header("Authorization") authToken: String,
        @Path("groupId") groupId: Int,
        @Path("date") date: String
    ): Call<List<ActivityReadDto>>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("/api/groups/{groupId}")
    fun getGroup(
        @Header("Authorization") authToken: String,
        @Path("groupId") groupId: Int
    ): Call<GroupReadDto>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("/api/account/login")
    fun login(@Body userData: LoginRequestDto): Call<LoginResponseDto>

    @POST("/api/observation")
    fun saveObservation(
        @Header("Authorization") authToken: String,
        @Body observationData: LoginRequestDto
    ): Call<String>

    companion object {
        const val BASE_URL: String = "http://192.168.0.16:5000"
    }
}