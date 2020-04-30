package kavin.learn.kotlinlearn.MvmmRecyclerview.Adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kavin.learn.kotlinlearn.MvmmRecyclerview.Pojo.PhotosPojo
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.list_photos.view.*

/**
 * Created by Kavin on 9/27/2019.
 */
class MvmmRecyclerAdapter(val c:Context,val phootlist:ArrayList<PhotosPojo>): RecyclerView.Adapter<MvmmRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(c).inflate(R.layout.list_photos, parent, false))
    }

    override fun getItemCount(): Int {
        return  phootlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.tv_photo_name.setText(phootlist[pos].title)
        Glide.with(c).load(phootlist[pos].url).into(holder.im_photo_row)
    }

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val im_photo_row = view.im_photo_row
        val tv_photo_name = view.tv_photo_name
    }

    fun setPhotsfromLiveData(list:List<PhotosPojo>){
        phootlist.addAll(list)
        notifyDataSetChanged()

    }

}