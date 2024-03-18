import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.careerhub.Models.CandidateData
import com.example.careerhub.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class CandidateAdapter(private val context: Context, options: FirebaseRecyclerOptions<CandidateData>) : FirebaseRecyclerAdapter<CandidateData, CandidateAdapter.CardViewHolder>(options){


    class CardViewHolder(inflater: LayoutInflater,parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.candidate_list,parent,false)) {

        val user_name: TextView = itemView.findViewById(R.id.user_name)
        val experience: TextView = itemView.findViewById(R.id.user_exp)
        val profile_img : ImageView = itemView.findViewById(R.id.profile_img)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.candidate_list, parent, false)
        return CardViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int, model: CandidateData) {
        val storageRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.profile_img)
        Glide.with(holder.profile_img.context).load(storageRef).into(holder.profile_img)
        holder.user_name.text = model.user_name
        holder.experience.text = model.experience

    }


}
