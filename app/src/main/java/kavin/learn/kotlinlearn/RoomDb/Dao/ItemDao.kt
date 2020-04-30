package kavin.learn.kotlinlearn.RoomDb.Dao


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo

/**
 * Created by Kavin on 9/27/2019.
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM item_pojo")
    fun getAllFeeds(): List<ItemPojo>

    @Query("SELECT name FROM item_pojo where name = :paramId")
     fun findById(paramId: String): String

    @Query("SELECT COUNT(*) from item_pojo")
     fun countFeeds(): Int

    @Insert
     fun insertList(feeds: List<ItemPojo>)

    @Insert
    fun insertOne(vararg todo: ItemPojo)

    @Delete
     fun delete(feed: ItemPojo)

    @Query("DELETE FROM item_pojo")
     fun clearAll()
}