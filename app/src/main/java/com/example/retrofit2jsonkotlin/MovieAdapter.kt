package com.example.retrofit2jsonkotlin
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (val postList: List<MoviesModel>, val context: Context?) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.txtTitle.text = postList[position].refNo1
        holder.itemView.txtExcerpt.text = postList[position].refNo2

//        Picasso.get().load(postList[position].thumbnail)
//            .error(R.mipmap.ic_launcher)
//            .placeholder(R.mipmap.ic_launcher)
//            .into(holder.itemView.imageView);
//
//        holder.itemView.cardView.setOnClickListener(View.OnClickListener { v ->
//            Toast.makeText(v.getContext(), "ID : "+postList[position].id, Toast.LENGTH_SHORT).show();
//        })
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}