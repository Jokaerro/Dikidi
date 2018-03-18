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
import inc.tesla.dikidi.repository.models.Category

class CategoryAdapter(private var items: List<Category>?, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items?.get(position) ?: return
        val viewHolder = holder as CategoryViewHolder
        Glide.with(context)
                .load(item.image)
                .into(viewHolder.photo)
        viewHolder.name.text = item.name
    }

    fun swapData(data: List<Category>?) {
        if (items != null) {
            items = data
            notifyDataSetChanged()
        }
    }

    internal class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.photo)
        var name: TextView = itemView.findViewById(R.id.name)
    }
}