package inc.tesla.dikidi.modules.main.adapters

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import inc.tesla.dikidi.R
import inc.tesla.dikidi.repository.models.Info

enum class MainAdapterEnum(val type: Int) {
    VIP(0), SHARES(1), CATEGORIES(2), POPULAR(3), EXAMPLES(4), NEW(5), CATALOG(6)
}

class MainAdapter(private val items: Info, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            MainAdapterEnum.VIP.type -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_main_vip, parent, false)
                return ViewHolderVip(itemView)
            }
            MainAdapterEnum.SHARES.type -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_main_shares, parent, false)
                return ViewHolderShares(itemView)
            }
            MainAdapterEnum.CATEGORIES.type -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_main_category, parent, false)
                return ViewHolderCategory(itemView)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_main_empty, parent, false)
                return ViewHolderEmpty(itemView)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            MainAdapterEnum.VIP.type -> {
                val viewHolder = holder as ViewHolderVip
                viewHolder.count.text = items.blocks.vip.size.toString()

                val adapter = VipAdapter(items.blocks.vip, context)
                val llm = LinearLayoutManager(context)
                llm.orientation = LinearLayoutManager.VERTICAL

                viewHolder.recycler.layoutManager = llm
                viewHolder.recycler.adapter = adapter
            }
            MainAdapterEnum.SHARES.type -> {
                val viewHolder = holder as ViewHolderShares
                viewHolder.count.text = items.blocks.shares.count

                val adapter = SharesAdapter(items.blocks.shares.list, context)
                val llm = LinearLayoutManager(context)
                llm.orientation = LinearLayoutManager.HORIZONTAL

                viewHolder.recycler.layoutManager = llm
                viewHolder.recycler.adapter = adapter

            }
            MainAdapterEnum.CATEGORIES.type -> {
                val viewHolder = holder as ViewHolderCategory
                viewHolder.count.text = items.blocks.categories.size.toString()

                val adapter = CategoryAdapter(items.blocks.categories, context)
                val llm = GridLayoutManager(context, 2)
                llm.orientation = LinearLayoutManager.HORIZONTAL

                viewHolder.recycler.layoutManager = llm
                viewHolder.recycler.adapter = adapter
            }
            else -> {

            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    internal class ViewHolderVip(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val recycler: RecyclerView = itemView.findViewById(R.id.vip_recycler)
    }

    internal class ViewHolderCategory(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val recycler: RecyclerView = itemView.findViewById(R.id.category_recycler)
    }

    internal class ViewHolderShares(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val recycler: RecyclerView = itemView.findViewById(R.id.shares_recycler)
    }

    internal class ViewHolderEmpty(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}