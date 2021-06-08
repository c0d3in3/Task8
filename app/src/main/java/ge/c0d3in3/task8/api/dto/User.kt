package ge.c0d3in3.task8.api.dto

import com.google.gson.annotations.SerializedName


data class User(

    val id: Long?,

    var email: String?,

    @SerializedName("first_name")
    var firstName: String?,

    @SerializedName("last_name")
    var lastName: String?,

    var avatar: String?

)

data class ReqResData<T>(

    val page: Int?,

    val data: T

)