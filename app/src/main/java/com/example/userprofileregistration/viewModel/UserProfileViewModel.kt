package com.example.userprofileregistration.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregistration.database.UserDatabase
import com.example.userprofileregistration.models.UserProfile
import com.example.userprofileregistration.repository.UserProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application):AndroidViewModel(application) {
    private val repository:UserProfileRepository

    init {
        val userProfileDao = UserDatabase.getDatabase(application).userProfileDao()
        repository = UserProfileRepository(userProfileDao)
    }

    fun getUserProfiles():LiveData<List<UserProfile>>{
        return repository.getUserProfiles()
    }

    fun insertUserProfile(userProfile: UserProfile){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(userProfile)
        }
    }

    fun updateUserProfile(userProfile: UserProfile){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(userProfile)
        }
    }

    fun deleteUserProfile(userProfile: UserProfile){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(userProfile)
        }
    }


}