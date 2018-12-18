package coesmapp.com.coesmapp.ui.home.meter_reading_fragmants

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle

class ConfirmationCodeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_confirmation_code, container, false)
        Log.d("ConfirmationCode", "OnCreate")

        return rootView
    }

    override fun onResume() {
        super.onResume()
        Log.d("ConfirmationCode", "Fragment Started")

        activity!!.setupToolbarAndTitle(R.id.toolbar_reading_schedule, "Booking Confirmed")

    }

//    companion object {
//        fun newInstance(): ConfirmationCodeFragment {
//            return ConfirmationCodeFragment()
//        }
//    }
}