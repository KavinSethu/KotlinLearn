package kavin.learn.kotlinlearn.RoomDb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kavin.learn.kotlinlearn.RoomDb.Dao.ItemDao
import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo

/**
 * Created by Kavin on 9/27/2019.
 */
@Database(entities = arrayOf(ItemPojo::class), version = 1,exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    companion object {
        var INSTANCE: RoomDB? = null

        fun getAppDataBase(context: Context): RoomDB? {
            if (INSTANCE == null){
                synchronized(RoomDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RoomDB::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

    abstract fun itemdao(): ItemDao
}