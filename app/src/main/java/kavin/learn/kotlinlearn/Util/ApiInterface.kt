package kavin.learn.kotlinlearn.Util

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import kavin.learn.kotlinlearn.MvmmRecyclerview.Pojo.PhotosPojo


/**
 * Created by Kavin on 9/27/2019.
 */
interface ApiInterface {

    @GET("photos")
    fun getAllPhotos(@Query("albumId") albumId: Long): Call<List<PhotosPojo>>
}