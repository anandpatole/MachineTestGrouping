package com.anand.myapplication

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import kotlin.collections.ArrayList

@RequiresApi(Build.VERSION_CODES.N)
class InnerRecyclerAdapter(
    private val context: Context,
    private var arrayList: ArrayList<Pair<String,   ArrayList<Pair<String, String>>>>,


    ) : RecyclerView.Adapter<InnerRecyclerAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.inner_row, parent, false))
    }



    override fun getItemCount(): Int {
        return arrayList?.size!!
    }


    @RequiresApi(Build.VERSION_CODES.N)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var pojo = arrayList?.get(position)

        holder.tid.text="TID : "+pojo?.first

        var adater =InnerMostRecyclerAdapter(context,pojo.second)
        holder.innermostRecycler.adapter=adater



    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val tid  =  item.findViewById<MaterialTextView>(R.id.tid)
        val innermostRecycler  =  item.findViewById<RecyclerView>(R.id.innermost_recycler)



    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}