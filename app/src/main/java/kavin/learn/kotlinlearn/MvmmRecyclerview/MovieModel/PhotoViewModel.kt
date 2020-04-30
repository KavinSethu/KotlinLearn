package kavin.learn.kotlinlearn.MvmmRecyclerview.MovieModel;

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import kavin.learn.kotlinlearn.MvmmRecyclerview.Pojo.PhotosPojo
import kavin.learn.kotlinlearn.MvmmRecyclerview.Repository.Repository
import kavin.learn.kotlinlearn.Util.ApiInterface
import kavin.learn.kotlinlearn.Util.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 * Created by Kavin on 9/27/2019.
 */
class PhotoViewModel() : ViewModel() {

    val repository=Repository()

    fun getImageList(albumId:Long): LiveData<List<PhotosPojo>>? {
        return repository.getPhotosList(albumId)
    }
}


