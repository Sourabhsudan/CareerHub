package com.example.careerhub.Models




import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.careerhub.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class CandidateAdapter(options: FirebaseRecyclerOptions<CandidateData>) : FirebaseRecyclerAdapter<CandidateData, CandidateAdapter.MyViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: CandidateData) {
        Glide.with(holder.imgPhoto.context).load(model.profile_img).into(holder.imgPhoto)
        holder.txtName.text = model.user_name
        holder.cardItem.setOnClickListener {
            val intent = Intent(holder.cardItem.context, CandidateActivity::class.java)
            intent.putExtra("user_id", model.user_id)
            intent.putExtra("user_name", model.user_name)
            intent.putExtra("email", model.email)
            intent.putExtra("address", model.address)
            intent.putExtra("qualifications", model.qualifications)
            intent.putExtra("experience", model.experience)
            intent.putExtra("profile_img", model.profile_img)
            holder.cardItem.context.startActivity(intent)
        }
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_candidate, parent, false)) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
        val cardItem: LinearLayout = itemView.findViewById(R.id.linearRow)
    }

}
