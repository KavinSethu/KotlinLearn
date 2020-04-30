package kavin.learn.kotlinlearn.RoomDb.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kavin.learn.kotlinlearn.MainPage.MainRecyclerAdapter
import kavin.learn.kotlinlearn.R
import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo
import kotlinx.android.synthetic.main.animal_row.view.*

/**
 * Created by Kavin on 9/27/2019.
 */
class RoomDbAdapter(val context:Context,val items:List<ItemPojo>) : RecyclerView.Adapter<ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvAnimalType?.text = items.get(position).name
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvAnimalType = view.tv_animal_type
}