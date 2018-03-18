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
import inc.tesla.dikidi.repository.models.Vip

class VipAdapter(private var items: List<Vip>?, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vip, parent, false)
        return VipViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items?.get(position) ?: return
        val viewHolder = holder as VipViewHolder
        Glide.with(context)
                .load(item.image.thumb)
                .into(viewHolder.image)
        viewHolder.title.text = item.name

        var categories = ""
        for (category in item.categories) {
            categories += category  + ", "
        }
        viewHolder.about.text = categories
    }

    fun swapData(data: List<Vip>?) {
        if (items != null) {
            items = data
            notifyDataSetChanged()
        }
    }

    internal class VipViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.title)
        var about: TextView = itemView.findViewById(R.id.about)
    }
}