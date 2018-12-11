package coesmapp.com.coesmapp.ui.home

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.fragment_capture_reading.view.*
import android.support.v4.content.FileProvider
import android.provider.MediaStore
import android.util.Log
import coesmapp.com.coesmapp.BuildConfig
import java.io.File
import java.io.IOException


class MeterReadingFragment : BaseFragment() {

    private lateinit var fileloc: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_meter_reading, container, false)
        view.toolbar_home.title = "Meter Reading Schedule"

        view.img_capture_reading.setOnClickListener {
            println("Capture picture clicked")
            openc()
        }
        return view
    }


    private fun openc() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var f: File? = null
        try {
            f = File.createTempFile("temppic", ".jpg", activity!!.applicationContext.cacheDir)
            if (takePictureIntent.resolveActivity(activity!!.packageManager) != null) {
                takePictureIntent.putExtra(
                    MediaStore.EXTRA_OUTPUT,
                    FileProvider.getUriForFile(activity!!, BuildConfig.APPLICATION_ID + ".provider", f!!)
                )
                fileloc = Uri.fromFile(f).toString()
                Log.d("texts", "openc: $fileloc")
                startActivityForResult(takePictureIntent, 3)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3 && resultCode == RESULT_OK) {
            Log.d("texts", "onActivityResult: $fileloc")
            // fileloc is the uri of the file so do whatever with it
        }
    }
}