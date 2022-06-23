package com.anand.myapplication

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@RequiresApi(Build.VERSION_CODES.N)
class RecyclerAdapter(
    private val context: Context,
    private var arrayList: ArrayList<Pair<String, HashMap<String, ArrayList<Pair<String, String>>>>>,


    ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))
    }



    override fun getItemCount(): Int {
        return arrayList?.size!!
    }


    @RequiresApi(Build.VERSION_CODES.N)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var pojo = arrayList?.get(position)

        holder.mid.text="MID : "+pojo?.first
        var mActualData:ArrayList<Pair<String,   ArrayList<Pair<String, String>>>> = arrayListOf()
        pojo.second?.forEach { s, s2 -> mActualData.add(Pair(s, s2)) }

        var innerRecyclerAdapter =InnerRecyclerAdapter(context,mActualData)
        holder.innerRecycler.adapter=innerRecyclerAdapter

        holder.cv.setOnClickListener {
            if(holder.innerRecycler.visibility==View.VISIBLE)
            {
                holder.innerRecycler.visibility=View.GONE
                holder.dropdown_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }
            else
            {
                holder.innerRecycler.visibility=View.VISIBLE
                holder.dropdown_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            }
        }

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val mid  =  item.findViewById<MaterialTextView>(R.id.mid)
        val dropdown_icon  =  item.findViewById<AppCompatImageView>(R.id.dropdown_icon)
        val innerRecycler  =  item.findViewById<RecyclerView>(R.id.inner_recycler)
        val cv  =  item.findViewById<CardView>(R.id.cv)



    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}