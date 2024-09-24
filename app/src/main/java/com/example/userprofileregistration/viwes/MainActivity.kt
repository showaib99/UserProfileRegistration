package com.example.userprofileregistration.viwes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofileregistration.R

class MainActivity : AppCompatActivity() {
    private lateinit var listButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listButton = findViewById(R.id.showUserListBtn)
        listButton.setOnClickListener{
            startActivity(Intent(this, ProfileListActivity::class.java))
            finish()
        }

    }
}