package coesmapp.com.coesmapp.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.DialogUtil
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import kotlinx.android.synthetic.main.fragment_capture_reading.*
import kotlinx.android.synthetic.main.fragment_capture_reading.view.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CaptureReadingFragment : BaseFragment() {

    private lateinit var currentPhotoPath: String
    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_capture_reading, container, false)

        activity!!.setupToolbarAndTitle(R.id.toolbar_home, "Capture meter reading")

        view.img_capture_reading.setOnClickListener {
            dispatchTakePictureIntent()
        }

        view.btn_submit_reading.setOnClickListener {
            // save the captured information in the database/or network. when successful display the dialog

            DialogUtil.createAlertDialogWithOneButton(
                activity!!,
                "Successfully Captured",
                "Your meter reading has been successfully captured. Your reference number is MRC010818",
                DialogInterface.OnClickListener { dialog, which ->
                    Navigation.findNavController(it).navigate(R.id.destination_home)
                    dialog.dismiss()
                }, "Cancel"
            ).show()
        }

        return view
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)

                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also { file ->
                    val photoURI: Uri = FileProvider.getUriForFile(
                        activity!!,
                        "coesmapp.com.coesmapp.fileprovider",
                        file
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras!!.get("data") as Bitmap
            img_capture_reading.setImageBitmap(imageBitmap)
        }
    }

    @Throws(IOException::class)
    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File {

        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = activity!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile("JPEG_${timestamp}_", ".jpg", storageDir).apply {
            currentPhotoPath = absolutePath
        }
    }

}