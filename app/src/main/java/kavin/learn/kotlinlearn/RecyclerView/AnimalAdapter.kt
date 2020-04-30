package kavin.learn.kotlinlearn.RecyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kavin.learn.kotlinlearn.MainPage.MainRecyclerAdapter
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.animal_row.view.*

/**
 * Created by Kavin on 9/27/2019.
 */
class AnimalAdapter(val context:Context,val items:ArrayList<String>,val oreientaion:String) : RecyclerView.Adapter<ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        if (oreientaion.equals("vertical"))
        {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false))
        }else {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_row_hori, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_animal_type2.visibility= View.VISIBLE
        holder?.tvAnimalType?.text = items.get(position)
        holder?.tv_animal_type2?.text = items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvAnimalType = view.tv_animal_type
    val tv_animal_type2 = view.tv_animal_type2
}