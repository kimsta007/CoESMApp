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

        return rootView
    }

    override fun onResume() {
        super.onResume()
        Log.d("ConfirmationCode", "Fragment Started")

        activity!!.setupToolbarAndTitle(R.id.toolbar_reading_schedule, "Booking Confirmed")

    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): ConfirmationCodeFragment {
            val fragment = ConfirmationCodeFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}