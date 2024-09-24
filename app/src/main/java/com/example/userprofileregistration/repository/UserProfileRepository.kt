package com.example.userprofileregistration.repository

import androidx.lifecycle.LiveData
import com.example.userprofileregistration.dao.UserProfileDao
import com.example.userprofileregistration.models.UserProfile

class UserProfileRepository(private val userProfileDao: UserProfileDao) {

    fun getUserProfiles():LiveData<List<UserProfile>>{
        return userProfileDao.getAllProfiles()
    }

    suspend fun insert(UserProfile: UserProfile){
        return userProfileDao.insert(UserProfile)
    }

    suspend fun update(UserProfile: UserProfile){
        return userProfileDao.insert(UserProfile)
    }

    suspend fun delete(UserProfile: UserProfile){
        return userProfileDao.insert(UserProfile)
    }
}