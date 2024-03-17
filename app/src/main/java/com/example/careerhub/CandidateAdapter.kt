package com.example.careerhub


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.careerhub.Models.CandidateData

class CandidateAdapter : RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>() {

    private var candidateList: List<CandidateData> = ArrayList()

    inner class CandidateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImg: ImageView = itemView.findViewById(R.id.profile_img)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val userExp: TextView = itemView.findViewById(R.id.user_exp)
        val userEmail: TextView = itemView.findViewById(R.id.user_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.candidate_list, parent, false)
        return CandidateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        val currentItem = candidateList[position]

        Glide.with(holder.itemView.context)
            .load(currentItem.profile_img)
            .into(holder.profileImg)

        holder.userName.text = currentItem.user_name
        holder.userExp.text = currentItem.experience
        holder.userEmail.text = currentItem.email
    }

    override fun getItemCount(): Int {
        return candidateList.size
    }
}


