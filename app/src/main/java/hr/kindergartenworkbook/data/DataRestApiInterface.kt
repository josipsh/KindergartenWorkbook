package hr.kindergartenworkbook.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DataRestApiInterface {
    @GET("/api")
    fun getUserImages(
        @Header("Authorization") authToken: String,
        @Query("userId") userId: Int): Call<List<String>>
}