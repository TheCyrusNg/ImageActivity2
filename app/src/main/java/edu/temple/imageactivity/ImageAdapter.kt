package edu.temple.imageactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (private val foodArray: Array<Image>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>()
{
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val imageView = itemView.findViewById<ImageView>(R.id.imageView2)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.itemholder, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView,mListener)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ImageAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val food: Image = foodArray[position]
        // Set item views based on your views and data model
        val imageView = viewHolder.imageView
        imageView.setImageResource(food.resourceId)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return foodArray.size
    }

}



