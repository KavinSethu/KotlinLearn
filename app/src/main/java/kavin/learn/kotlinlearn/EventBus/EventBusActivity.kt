package kavin.learn.kotlinlearn.EventBus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.reactivex.disposables.Disposable
import kavin.learn.kotlinlearn.EventBus.Model.RxEvent
import kavin.learn.kotlinlearn.EventBus.Rxbus.RxBus
import kavin.learn.kotlinlearn.R
import kavin.learn.kotlinlearn.RoomDb.Adapter.RoomDbAdapter
import kavin.learn.kotlinlearn.RoomDb.DbWorkerThread
import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo
import kavin.learn.kotlinlearn.RoomDb.RoomDB
import kotlinx.android.synthetic.main.activity_event_bus.*
import kotlinx.android.synthetic.main.activity_room_db.*

class EventBusActivity : AppCompatActivity() {

    lateinit var list:List<ItemPojo>
    lateinit var roomDbAdapter: RoomDbAdapter
    private lateinit var personDisposable: Disposable

    private var roomDB: RoomDB? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)

        //RoomDB init
        roomDB= RoomDB.getAppDataBase(this)

        //Worker Thread
        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()

        //Recyclerview Layout Manager
        val layManager=LinearLayoutManager(this)
        rxbus_recycler.layoutManager= layManager

        //Listen the data
        personDisposable = RxBus.listen(RxEvent.EventAddItem::class.java).subscribe {
            Toast.makeText(this,"Event Listen",Toast.LENGTH_SHORT).show()
            insertDataInDb(it.itemPojo)
        }

        //Post event
        btn_insert_rx.setOnClickListener(){
            val data:String= et_data_rx.text.toString()

            if (data!=null && !data.equals("")){
                val itemPojo:ItemPojo=ItemPojo(data,data,0)
                //Publish the Event Bus
                RxBus.publish(RxEvent.EventAddItem(itemPojo))
                et_data_rx.setText("")
            }else{
                Toast.makeText(this,"Insert Data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun insertDataInDb(itemPojo: ItemPojo) {
        val task = Runnable { roomDB?.itemdao()?.insertOne(itemPojo) }
        mDbWorkerThread.postTask(task)
        Log.d("RoomDB","DataInsert")
        fetchDataFromDb()

    }

    private fun fetchDataFromDb() {
        val task = Runnable {
            list=ArrayList()
            list = roomDB?.itemdao()?.getAllFeeds()!!
            Log.d("RoomDB_List",""+roomDB?.itemdao()?.countFeeds())
            Log.d("RoomDB_List",""+list.size)
            mUiHandler.post({
                if (list == null || list?.size == 0) {
                    Log.d("RoomDB","DataEmpty")
                } else {
                    Log.d("RoomDB","Data")
                    roomDbAdapter= RoomDbAdapter(this,list)
                    rxbus_recycler.adapter=roomDbAdapter

                }
            })
        }
        mDbWorkerThread.postTask(task)
    }
}
