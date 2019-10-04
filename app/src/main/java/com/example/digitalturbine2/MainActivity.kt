package com.example.digitalturbine2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.digitalturbine2.adapter.MyAdapter
import com.example.digitalturbine2.api.RetrofitClient
import com.example.digitalturbine2.model.Campaign
import com.example.digitalturbine2.model.DefaultResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RetrofitClient.instance.getDetails().enqueue(object: Callback<DefaultResponse> {
            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {

                recycler_view.apply {
                    layoutManager = GridLayoutManager(this@MainActivity,2)
                    adapter = MyAdapter(response.body()?.campaigns as List<Campaign>?)

                }
              //  Toast.makeText(applicationContext, response.body()?.campaigns?.get(0)?.productName, Toast.LENGTH_LONG).show()
            }

        }

        )
    }
}
