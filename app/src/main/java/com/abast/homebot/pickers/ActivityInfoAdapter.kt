package com.abast.homebot.pickers

import android.content.Context
import android.content.pm.ActivityInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abast.homebot.R
import kotlinx.android.synthetic.main.list_item.view.*

class ActivityInfoAdapter(private val context : Context, val onItemClick: (ActivityInfo) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : Array<ActivityInfo> = emptyArray()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.get(position)
        val vh : ListItemViewHolder = holder as ListItemViewHolder
        vh.image.setImageDrawable(item.loadIcon(context.packageManager))
        vh.subtitle.text = item.name
        vh.label.text = item.loadLabel(context.packageManager)
    }

    inner class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val label = view.label
        val subtitle = view.subtitle
        val image = view.image

        init{
            view.setOnClickListener{
                onItemClick.invoke(items[adapterPosition])
            }
        }
    }

}