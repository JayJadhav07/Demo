package com.example.loginkotlinpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val toast= Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,1000)
            toast.show()

    }

}
