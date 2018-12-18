package coesmapp.com.coesmapp.ui.home.meter_reading_fragmants

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.displaySpinner
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import kotlinx.android.synthetic.main.fragment_choose_date.view.*
import java.util.*

class ChooseDateFragment : BaseFragment() {
    private lateinit var scheduleDate: Date

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_choose_date, container, false)


        rootView.cv_date_schedule.setOnDateChangeListener { view, year, month, dayOfMonth ->
            println("Selected Date Long ${view.date}     Year : $year   Month : $month   Day : $dayOfMonth")
            scheduleDate = Date(view.date)
        }

        rootView.spinner_start_time.displaySpinner(activity!!, R.array.business_hours)
        rootView.spinner_end_time.displaySpinner(activity!!, R.array.business_hours)

        return rootView
    }

    override fun onResume() {
        super.onResume()
        Log.d("ChooseDateFragment", "Fragment Started")

        activity!!.setupToolbarAndTitle(R.id.toolbar_reading_schedule, "Meter Reading Date")


    }
}