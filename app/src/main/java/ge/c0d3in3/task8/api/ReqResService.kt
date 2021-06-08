package ge.c0d3in3.task8.api

import ge.c0d3in3.task8.api.dto.ReqResData
import ge.c0d3in3.task8.api.dto.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface ReqResService {

    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<ReqResData<List<User>>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Long): Call<ReqResData<User>>

}