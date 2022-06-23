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
class InnerMostRecyclerAdapter(
    private val context: Context,
    private var arrayList: ArrayList<Pair<String, String>>,


    ) : RecyclerView.Adapter<InnerMostRecyclerAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.inner_most_row, parent, false))
    }



    override fun getItemCount(): Int {
        return arrayList?.size!!
    }


    @RequiresApi(Build.VERSION_CODES.N)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var pojo = arrayList?.get(position)

        holder.narration.text=pojo?.first
        holder.amount.text="₹ "+pojo?.second






    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val narration  =  item.findViewById<MaterialTextView>(R.id.narration)
        val amount  =  item.findViewById<MaterialTextView>(R.id.amount)



    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}