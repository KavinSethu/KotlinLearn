package kavin.learn.kotlinlearn.EventBus.Model

import kavin.learn.kotlinlearn.RoomDb.Pojo.ItemPojo

/**
 * Created by Kavin on 10/1/2019.
 */
class RxEvent{

    data class EventAddItem(val itemPojo: ItemPojo)
}