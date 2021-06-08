package ge.c0d3in3.task8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import ge.c0d3in3.task8.api.RetrofitClient
import ge.c0d3in3.task8.api.dto.ReqResData
import ge.c0d3in3.task8.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(){
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("userId", it.id)
            startActivity(intent)
        }
        recyclerView = findViewById(R.id.userRv)
        recyclerView.adapter = adapter
        getUsers()

    }

    private fun getUsers() {

        RetrofitClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>> {

            override fun onResponse(
                    call: Call<ReqResData<List<User>>>,
                    response: Response<ReqResData<List<User>>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val users = response.body()!!.data
                    adapter.setUsers(users)
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
            }

        })

    }

}