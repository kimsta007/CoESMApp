package coesmapp.com.coesmapp.ui.home

import android.Manifest.permission.CAMERA
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private lateinit var photoURI: Uri
    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_capture_reading, container, false)

        activity!!.setupToolbarAndTitle(R.id.toolbar_home, "Capture meter reading")

        view.btn_submit_reading.isEnabled = false

        view.img_capture_reading.setOnClickListener {
            if (checkForPermission()) {
                dispatchTakePictureIntent()

            } else {
                requestPermission()
            }

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
                    photoURI = FileProvider.getUriForFile(
                        activity!!,
                        "coesmapp.com.coesmapp.fileprovider",
                        file
                    )
                }
                println("PhotoURI : ${photoURI}")
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            data?.let {
                val imageBitmap = data.extras!!.get("data") as Bitmap
                img_capture_reading.setImageBitmap(imageBitmap)
                btn_submit_reading.isEnabled = true

            }
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

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            activity!!,
            arrayOf(WRITE_EXTERNAL_STORAGE, CAMERA),
            1
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty()) {
                    val storagePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val cameraPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED
                    if (storagePermission && cameraPermission) {
                        Toast.makeText(activity!!, "Permission Granted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity!!, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun checkForPermission(): Boolean {
        val externalStorage = ContextCompat.checkSelfPermission(activity!!.applicationContext, WRITE_EXTERNAL_STORAGE)
        val cameraPermission = ContextCompat.checkSelfPermission(activity!!.applicationContext, CAMERA)

        return externalStorage == PackageManager.PERMISSION_GRANTED && cameraPermission == PackageManager.PERMISSION_GRANTED
    }


}