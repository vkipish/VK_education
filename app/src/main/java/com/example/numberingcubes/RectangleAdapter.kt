package com.example.numberingcubes

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.numberingcubes.R

class RectangleAdapter : RecyclerView.Adapter<RectangleAdapter.RectangleViewHolder>() {
    private var itemCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int) : RectangleViewHolder{

        val inflater = LayoutInflater.from(parent.context)
        val newRectangle = inflater.inflate(R.layout.cubes, parent, false)
        return RectangleViewHolder(newRectangle)
    }

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    fun AddItem(){
        itemCount++
        notifyItemInserted(itemCount - 1)
    }

    class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val numberText: TextView = itemView.findViewById(R.id.numberText)
        private val container: LinearLayout = itemView as LinearLayout

        fun bind (coordinates : Int){
            val number = coordinates + 1
            numberText.text = number.toString()
            val colorRectangle = if (number % 2 == 0) {
                Color.RED }
            else{
                Color.BLUE
            }
            val textColor = Color.WHITE
            container.setBackgroundColor(colorRectangle)
            numberText.setTextColor(textColor)
        }
    }
}