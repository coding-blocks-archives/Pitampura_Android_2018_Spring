package com.codingblocks.consumerestapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.codingblocks.consumerestapi.R
import com.codingblocks.consumerestapi.api.JpApi
import com.codingblocks.consumerestapi.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersActivity : AppCompatActivity() {
    val TAG = "RETROFIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val r: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = r.create(JpApi::class.java)
        api.getUsers().enqueue(object: Callback<Array<User>> {
            override fun onFailure(call: Call<Array<User>>?, t: Throwable?) {
                Log.e(TAG, "ERROR GET /users", t)
                Toast.makeText(this@UsersActivity, "Could not fetch users", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Array<User>>?, response: Response<Array<User>>?) {
                val l = response?.body()?.size
                if (l != null) {
                    Log.d(TAG, response.body()!![0].name)
                }
            }

        } )

    }
}
