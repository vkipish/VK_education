package com.example.numberingcubes

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.view.LayoutInflater
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class RectangleAdapter : RecyclerView.Adapter<RectangleAdapter.RectangleViewHolder>() {
    private var itemCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectangleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val newRectangle = inflater.inflate(R.layout.cubes, parent, false)
        return RectangleViewHolder(newRectangle)
    }

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.post {
            val size = min(holder.itemView.width, holder.itemView.height)
            holder.itemView.layoutParams.apply {
                width = size
                height = size
            }
            holder.itemView.requestLayout()
        }
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    fun AddItem() {
        itemCount++
        notifyItemInserted(itemCount - 1)
    }

    fun getCurrentCount(): Int = itemCount

    fun setCount(count: Int) {
        itemCount = count
        notifyDataSetChanged()
    }

    fun clearItems() {
        itemCount = 0
        notifyDataSetChanged()
    }

    class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberText: TextView = itemView.findViewById(R.id.numberText)
        private val container: LinearLayout = itemView as LinearLayout

        fun bind(coordinates: Int) {
            val number = coordinates + 1
            numberText.text = number.toString()
            val colorRectangle = if (number % 2 == 0) Color.RED else Color.BLUE
            val textColor = Color.WHITE
            container.setBackgroundColor(colorRectangle)
            numberText.setTextColor(textColor)

            itemView.setOnClickListener {
                openDetailActivity(number, colorRectangle)
            }
        }

        private fun openDetailActivity(number: Int, backgroundColor: Int) {
            val context = itemView.context
            val intent = Intent(context, SquareDetailActivity::class.java).apply {
                putExtra("NUMBER", number)
                putExtra("BACKGROUND_COLOR", backgroundColor)
            }
            context.startActivity(intent)
        }
    }
}