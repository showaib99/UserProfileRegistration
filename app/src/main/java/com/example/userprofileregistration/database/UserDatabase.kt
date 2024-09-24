package com.example.userprofileregistration.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration.dao.UserProfileDao
import com.example.userprofileregistration.models.UserProfile
import kotlinx.coroutines.internal.synchronized



@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userProfile():UserProfileDao
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE:UserDatabase? =null

        fun getDatabase(context:Context):UserDatabase{
            return INSTANCE?: kotlin.synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance

            }
        }
    }

}