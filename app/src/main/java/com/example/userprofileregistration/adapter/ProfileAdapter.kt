package com.example.userprofileregistration.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration.R
import com.example.userprofileregistration.models.UserProfile

class ProfileAdapter() :ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback()) {
    private var onItemClickListener:((UserProfile)->Unit)?=null
    private var onDeleteClickListener:((UserProfile)->Unit)?=null
    private var onEditClickListener:((UserProfile)->Unit)?=null

    fun setOnItemClickListener(listener:(UserProfile)->Unit){
        onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener:(UserProfile)->Unit){
        onItemClickListener = listener
    }
    fun setOnEditClickListener(listener:(UserProfile)->Unit){
        onItemClickListener = listener
    }
    class ProfileViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val profileName:TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail:TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDOB:TextView = itemView.findViewById(R.id.userDOBTxt)
        private val profileDistrict:TextView = itemView.findViewById(R.id.userDistrictTxt)
        private val profileMobile:TextView = itemView.findViewById(R.id.userMobileTxt)
        private val updateBtn:TextView = itemView.findViewById(R.id.editBtn)
        private val deleteBtn:TextView = itemView.findViewById(R.id.deleteBtn)


        fun bind(userProfile: UserProfile){
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDOB.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_listlayout, parent, false)
        return ProfileViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback:DiffUtil.ItemCallback<UserProfile>(){
    override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return oldItem == newItem
    }

}