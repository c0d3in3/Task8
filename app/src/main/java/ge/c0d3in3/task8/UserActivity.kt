package ge.c0d3in3.task8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ge.c0d3in3.task8.api.RetrofitClient
import ge.c0d3in3.task8.api.dto.ReqResData
import ge.c0d3in3.task8.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    private lateinit var nameTv: TextView
    private lateinit var lastNameTv: TextView
    private lateinit var emailTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        nameTv = findViewById(R.id.nameTv)
        lastNameTv = findViewById(R.id.lastNameTv)
        emailTv = findViewById(R.id.emailTv)

        val userId = intent.getLongExtra("userId", 0L)
        getUser(userId)
    }

    private fun getUser(userId: Long){
        RetrofitClient.reqResApi.getUser(userId).enqueue(object : Callback<ReqResData<User>> {

            override fun onResponse(
                call: Call<ReqResData<User>>,
                response: Response<ReqResData<User>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val user = response.body()!!.data

                    nameTv.text = user.firstName
                    lastNameTv.text = user.lastName
                    emailTv.text = user.email
                }
            }

            override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
            }

        })
    }
}