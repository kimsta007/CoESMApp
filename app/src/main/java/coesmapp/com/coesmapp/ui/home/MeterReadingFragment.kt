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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_meter_reading, container, false)
        view.toolbar_home.title = "Meter Reading Schedule"

        return view
    }



}