package kavin.learn.kotlinlearn.RuntimePermissions

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.activity_run_time_permission.*
import java.util.jar.Manifest

class RunTimePermissionActivity : AppCompatActivity() {

    private val TAG = "RunTimePermission"
    private val REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_time_permission)

        btn_per.setOnClickListener(){
            checkSelefPermissions()
        }


    }

    private fun checkSelefPermissions() {
        val permission=ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permission2=ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED && permission2 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }else{
            Toast.makeText(this,"Already Granted",Toast.LENGTH_SHORT).show()
        }


    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){

            REQUEST_CODE->{
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                    Toast.makeText(this,"Permission has been denied by user",Toast.LENGTH_SHORT).show()
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                    Toast.makeText(this,"Permission has been granted by user",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
