package kavin.learn.kotlinlearn.MainPage;

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kavin.learn.kotlinlearn.EventBus.EventBusActivity
import kavin.learn.kotlinlearn.MvmmRecyclerview.Activity.MvmmRecyclerviewActivity
import kavin.learn.kotlinlearn.R
import kavin.learn.kotlinlearn.RecyclerView.RecyclerviewActivity
import kavin.learn.kotlinlearn.RoomDb.RoomDBActivity
import kavin.learn.kotlinlearn.RuntimePermissions.RunTimePermissionActivity
import kavin.learn.kotlinlearn.TabLayout_ViewPager.TabLayoutActivity

/**
 * Created by Kavin on 9/23/2019.
 */
class MainRecyclerAdapter(val c: Context, val itemlist: List<MainPojos>) :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): MainRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_mainpage, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        val main: MainPojos = itemlist[pos]
        holder.name.setText(main.name)

        holder.itemView.setOnClickListener {
            if (main.type.contentEquals("runtime")) {
                val intent=Intent(c,RunTimePermissionActivity::class.java)
                c.startActivity(intent)
            } else if (main.type.contentEquals("recyclerview")) {
                val intent=Intent(c,RecyclerviewActivity::class.java)
                c.startActivity(intent)
            }else if (main.type.contentEquals("mvmm_recyclerview")) {
                val intent=Intent(c,MvmmRecyclerviewActivity::class.java)
                c.startActivity(intent)
            }else if (main.type.contentEquals("roomdb")) {
                val intent=Intent(c,RoomDBActivity::class.java)
                c.startActivity(intent)
            }else if (main.type.contentEquals("rxbus")) {
                val intent=Intent(c,EventBusActivity::class.java)
                c.startActivity(intent)
            }/*else if (main.type.contentEquals("fcm")) {
                val intent=Intent(c,PushNotificationActivity::class.java)
                c.startActivity(intent)
            }*/else if (main.type.contentEquals("tabs")) {
                val intent=Intent(c,TabLayoutActivity::class.java)
                c.startActivity(intent)
            }
        }
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val name: TextView = itemview.findViewById(R.id.tv_main_row)
    }
}
