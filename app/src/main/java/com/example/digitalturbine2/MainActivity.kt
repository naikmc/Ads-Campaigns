package com.example.digitalturbine2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalturbine2.ui.AppListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, AppListFragment.newInstance()).commit()
        }


    }
}
