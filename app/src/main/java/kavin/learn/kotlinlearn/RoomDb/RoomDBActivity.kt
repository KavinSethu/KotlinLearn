package kavin.learn.kotlinlearn.RoomDb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kavin.learn.kotlinlearn.RoomDb.Adapter.RoomDbAdapter
import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo
import kotlinx.android.synthetic.main.activity_event_bus.*
import kotlinx.android.synthetic.main.activity_room_db.*


class RoomDBActivity : AppCompatActivity() {

    lateinit var list:List<ItemPojo>
    lateinit var roomDbAdapter: RoomDbAdapter
    private var roomDB: RoomDB? = null

    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(kavin.learn.kotlinlearn.R.layout.activity_room_db)

        roomDB= RoomDB.getAppDataBase(this)
        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()

        list= ArrayList<ItemPojo>()
        roomdb_recycler.layoutManager=LinearLayoutManager(this)
        roomDbAdapter=RoomDbAdapter(this,list)
        roomdb_recycler.adapter=roomDbAdapter

        fetchDataFromDb()

        btn_insert.setOnClickListener(){
            val data:String= et_data.text.toString()

            if (data!=null && !data.equals("")){
                val itemPojo:ItemPojo=ItemPojo(data,data,0)
                insertDataInDb(itemPojo)
                et_data.setText("")
            }else{
                Toast.makeText(this,"Insert Data",Toast.LENGTH_SHORT).show()
            }
        }
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
                    roomDbAdapter=RoomDbAdapter(this,list)
                    roomdb_recycler.adapter=roomDbAdapter

                }
            })
        }
        mDbWorkerThread.postTask(task)
    }

    private fun insertDataInDb(itemPojo: ItemPojo) {
        val task = Runnable { roomDB?.itemdao()?.insertOne(itemPojo) }
        mDbWorkerThread.postTask(task)
        Log.d("RoomDB","DataInsert")
        fetchDataFromDb()
    }

    override fun onDestroy() {
        RoomDB.destroyDataBase()
        mDbWorkerThread.quit()
        super.onDestroy()
    }

}
