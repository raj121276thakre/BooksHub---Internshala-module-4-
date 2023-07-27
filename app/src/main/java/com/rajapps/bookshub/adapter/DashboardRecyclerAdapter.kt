package com.rajapps.bookshub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rajapps.bookshub.R
import com.rajapps.bookshub.model.Book

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val book = itemList[position]
        holder.txtBookName.text = book.bookname
        holder.txtAuthorName.text = book.bookAuthor
        holder.txtPrice.text = book.bookCost
        holder.txtRating.text = book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)

        holder.llContent.setOnClickListener{
            Toast.makeText(context,"You have some intrest in ${holder.txtBookName.text}'s work.",
                Toast.LENGTH_SHORT).show()
        }

    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){

        val txtBookName : TextView = view.findViewById(R.id.txtBookName)
        val txtAuthorName : TextView = view.findViewById(R.id.txtAuthorName)
        val txtPrice : TextView = view.findViewById(R.id.txtPrice)
        val txtRating : TextView = view.findViewById(R.id.txtRating)
        val imgBookImage : ImageView = view.findViewById(R.id.imgBookImage)
        val llContent: RelativeLayout =view.findViewById(R.id.llContent)

    }

}












