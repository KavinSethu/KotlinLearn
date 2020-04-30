package kavin.learn.kotlinlearn.RoomDb.Pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Kavin on 9/27/2019.
 */
@Entity(tableName = "item_pojo")
class ItemPojo(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "age") var age: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
)

{


}