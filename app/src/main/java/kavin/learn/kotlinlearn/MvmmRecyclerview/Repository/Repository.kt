package kavin.learn.kotlinlearn.MvmmRecyclerview.Repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import kavin.learn.kotlinlearn.MvmmRecyclerview.MovieModel.PhotoViewModel
import kavin.learn.kotlinlearn.MvmmRecyclerview.Pojo.PhotosPojo
import kavin.learn.kotlinlearn.Util.ApiInterface
import kavin.learn.kotlinlearn.Util.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * Created by Kavin on 10/3/2019.
 */
class Repository() {

    var photoList: List<PhotosPojo> = ArrayList()
    private val mutablephotoList: MutableLiveData<List<PhotosPojo>> = MutableLiveData()

    fun getPhotosList(alubmid:Long):LiveData<List<PhotosPojo>>?{

        var retroClient= Retrofit.client.create(ApiInterface::class.java)
        val call=retroClient.getAllPhotos(alubmid)

        call.enqueue(object : Callback<List<PhotosPojo>> {
            override fun onResponse(call: Call<List<PhotosPojo>>, response: Response<List<PhotosPojo>>) {

                val jsonResponse = response.body()
                Log.d("getPhotosList", " "+jsonResponse)
                photoList = response.body()!!
                mutablephotoList.postValue(photoList)
            }

            override fun onFailure(call: Call<List<PhotosPojo>>?, t: Throwable?) {
                Log.d("getPhotosList : ", "Error")
            }
        })

        return mutablephotoList
    }

}
