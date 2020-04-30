package kavin.learn.kotlinlearn.MainPage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var itemlist: List<MainPojos>
    lateinit var mainRecyclerAdapter: MainRecyclerAdapter
    lateinit var laymanger:RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemlist = ArrayList<MainPojos>()

        //adding some dummy data to the list
        itemlist.add(MainPojos("Run Time Permissions","runtime"))
        itemlist.add(MainPojos("Simple Recyclerview","recyclerview"))
        itemlist.add(MainPojos("Mvmm Recyclerview","mvmm_recyclerview"))
        itemlist.add(MainPojos("RoomDB","roomdb"))
        itemlist.add(MainPojos("RxBus(EventBus)","rxbus"))
        itemlist.add(MainPojos("Firebase Notification","fcm"))
        itemlist.add(MainPojos("TabLayout+Viewpager","tabs"))

        //creating our adapter
        mainRecyclerAdapter = MainRecyclerAdapter(this,itemlist)

        laymanger=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recylerview_mainpage.layoutManager=laymanger

        //now adding the adapter to recyclerview
        recylerview_mainpage.adapter = mainRecyclerAdapter

    }
}
