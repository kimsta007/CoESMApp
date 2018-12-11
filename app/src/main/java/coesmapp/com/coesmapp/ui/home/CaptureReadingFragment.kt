package coesmapp.com.coesmapp.ui.home

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
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

private const val  REQUEST_IMAGE_CAPTURE = 1

class CaptureReadingFragment : BaseFragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_capture_reading, container, false)

        activity!!.setupToolbarAndTitle(R.id.toolbar_home, "Capture meter reading")

        view.img_capture_reading.setOnClickListener {
            println("Capture picture clicked")
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
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras!!.get("data") as Bitmap
            img_capture_reading.setImageBitmap(imageBitmap)
        }
    }
}