package com.example.userprofileregistration.viwes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration.R
import com.example.userprofileregistration.adapter.ProfileAdapter
import com.example.userprofileregistration.viewModel.UserProfileViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileListActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list)
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        profileAdapter = ProfileAdapter()

        recyclerView.adapter = profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this, Observer {
            profileAdapter.submitList(it)
        })

        profileAdapter.setOnItemClickListener {
            val intent = Intent(this, SingleProfileActivity::class.java)
            intent.putExtra("USER_PROFILE", it)
            startActivity(intent)
        }


        profileAdapter.setOnEditClickListener {
            val intent = Intent(this, UpdateProfileActivity::class.java)
            intent.putExtra("USER_PROFILE", it)
            startActivity(intent)
        }

        profileAdapter.setOnDeleteClickListener {
            profileViewModel.deleteUserProfile(it)

        }

        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener{
            startActivity(Intent(this,AddProfileActivity::class.java))
        }

    }
}