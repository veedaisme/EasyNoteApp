package com.vibelous.iqbaaaaalf.easynoteskotlin

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by iqbaaaaalf on 12/12/2017.
 */
class AppExecutors(diskIO: Executor, networkIo: Executor, mainThread: Executor) {

    val diskIO: Executor = diskIO
    val networkIo: Executor = networkIo
    val mainThread: Executor = mainThread


    companion object {
        val LOCK: Object = Object()
        var sInstance: AppExecutors? = null

        fun getInstance(): AppExecutors? {
            if(sInstance == null){
                synchronized(LOCK){
                    sInstance = AppExecutors(Executors.newSingleThreadExecutor(),
                            Executors.newFixedThreadPool(3), MainThreadExecutor())
                }
            }
            return sInstance
        }
    }

    class MainThreadExecutor : Executor{
        private val mainThreadhandler: Handler = Handler(Looper.getMainLooper())

        override fun execute(p0: Runnable?) {
            mainThreadhandler.post { p0 }
        }
    }

}