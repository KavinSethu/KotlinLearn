package kavin.learn.kotlinlearn.EventBus.Rxbus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Kavin on 10/1/2019.
 */
object RxBus {

    private val publisher = PublishSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }

    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}