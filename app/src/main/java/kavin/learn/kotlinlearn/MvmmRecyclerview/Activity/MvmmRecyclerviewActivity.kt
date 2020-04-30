package kavin.learn.kotlinlearn.MvmmRecyclerview.Activity

import android.app.ProgressDialog
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kavin.learn.kotlinlearn.MvmmRecyclerview.Adapter.MvmmRecyclerAdapter
import kavin.learn.kotlinlearn.MvmmRecyclerview.MovieModel.PhotoViewModel
import kavin.learn.kotlinlearn.MvmmRecyclerview.Pojo.PhotosPojo
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.activity_mvmm_recyclerview.*

class MvmmRecyclerviewActivity : AppCompatActivity() {

    var viewModel:PhotoViewModel?=null
    val photolist: ArrayList<PhotosPojo> = ArrayList()
    lateinit var  laymanger: RecyclerView.LayoutManager
    lateinit var  gridLayoutManager: GridLayoutManager
    lateinit var proadapter:MvmmRecyclerAdapter
    var isLoading:Boolean = false
    var albumId:Long=1
    lateinit var progressDialog:ProgressDialog;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvmm_recyclerview)

        proadapter=MvmmRecyclerAdapter(this,photolist)
        gridLayoutManager= GridLayoutManager(this,2)
        recyclerview_mvmm.layoutManager=gridLayoutManager;
        recyclerview_mvmm.adapter= proadapter
        recyclerview_mvmm.addOnScrollListener(recyclerViewOnScrollListener)

        progressDialog= ProgressDialog(this)
        progressDialog.setMessage("Loading")

        viewModel= ViewModelProviders.of(this).get(PhotoViewModel::class.java)
//        viewModel= PhotoViewModel(this)
        subscribeDataCallBack()
    }

    private fun subscribeDataCallBack() {
        progressDialog.show()
        viewModel?.getImageList(albumId)?.observe(this, android.arch.lifecycle.Observer<List<PhotosPojo>>{

            if (it != null && it.size>0) {
                var temp :Int=it.size
                albumId=albumId+1
                Log.d("albumId",""+albumId)
                Log.d("PhotoList",""+it.size)
                proadapter.setPhotsfromLiveData(it)
                isLoading=false
                progressDialog.dismiss()

            }else{
                Log.d("Stop","Pagination")
                isLoading=true
                progressDialog.dismiss()
            }

        })

    }


    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount: Int
            val totalItemCount: Int
            val firstVisibleItemPosition: Int

            visibleItemCount = gridLayoutManager.getChildCount()
            totalItemCount = gridLayoutManager.getItemCount()
            firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition()

            if (!isLoading) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= 5) {

                    isLoading = true
                    subscribeDataCallBack()

                }
            }

        }
    }
}
