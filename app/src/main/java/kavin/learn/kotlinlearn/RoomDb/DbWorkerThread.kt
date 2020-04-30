package kavin.learn.kotlinlearn.RoomDb;

import android.os.Handler
import android.os.HandlerThread

/**
 * Created by Kavin on 10/1/2019.
 */
public class DbWorkerThread(threadName: String) : HandlerThread(threadName) {

private lateinit var mWorkerHandler: Handler

        override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
        }

        fun postTask(task: Runnable) {
        mWorkerHandler.post(task)
        }

        }
