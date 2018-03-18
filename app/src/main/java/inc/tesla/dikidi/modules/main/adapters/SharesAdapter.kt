package inc.tesla.dikidi.modules.main.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import inc.tesla.dikidi.R
import inc.tesla.dikidi.repository.models.SharesList

class SharesAdapter(private var items: List<SharesList>?, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shares, parent, false)
        return SharesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items?.get(position) ?: return
        val viewHolder = holder as SharesViewHolder
        Glide.with(context)
                .load(item.icon)
                .into(viewHolder.background)
        viewHolder.message.text = item.name
        viewHolder.name.text = item.companyName
        viewHolder.address.text = item.companyStreet + " " + item.companyHouse
        Glide.with(context)
                .load(item.companyImage)
                .into(viewHolder.photo)
    }

    fun swapData(data: List<SharesList>?) {
        if (items != null) {
            items = data
            notifyDataSetChanged()
        }
    }

    internal class SharesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var background: ImageView = itemView.findViewById(R.id.background)
        var photo: ImageView = itemView.findViewById(R.id.photo)
        var message: TextView = itemView.findViewById(R.id.message)
        var name: TextView = itemView.findViewById(R.id.name)
        var address: TextView = itemView.findViewById(R.id.address)
    }
}