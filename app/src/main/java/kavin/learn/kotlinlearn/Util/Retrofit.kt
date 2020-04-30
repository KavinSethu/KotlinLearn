package kavin.learn.kotlinlearn.Util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Kavin on 9/27/2019.
 */
class Retrofit{


    companion object {

        val baseURL:String = "https://jsonplaceholder.typicode.com/"
        var retofit: Retrofit? = null

        val client: Retrofit
            get() {

                if (retofit == null) {
                    retofit = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retofit !!
            }
    }
}