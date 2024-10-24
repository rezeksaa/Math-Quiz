package com.example.mathquizsolo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class rvAdapter(val listData : ArrayList<Quiz>) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = view.findViewById(R.id.imagePhoto)
        val name : TextView = view.findViewById(R.id.Quiz_Name)
        val solve : Button = view.findViewById(R.id.Solve_Button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (photo, Quizname) = listData[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(100, 100))
            .into(holder.image)

        holder.name.text = Quizname

        holder.solve.setOnClickListener {
            val intent =Intent(holder.itemView.context, QuizPage::class.java)
            intent.putExtra("QuizType", Quizname)
            holder.itemView.context.startActivity(intent)
        }
    }
}