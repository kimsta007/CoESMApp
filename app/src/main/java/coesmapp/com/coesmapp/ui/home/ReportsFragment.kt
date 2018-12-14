package coesmapp.com.coesmapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.displaySpinner
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import kotlinx.android.synthetic.main.fragment_reports.*
import kotlinx.android.synthetic.main.fragment_reports.view.*

class ReportsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reports, container, false)

        activity!!.setupToolbarAndTitle(R.id.toolbar_home, getString(R.string.reports_title))

        view.spinner_readings_range.displaySpinner(activity!!, R.array.readings_range)

        view.spinner_readings_range.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> showStatisticsPerRange(position)
                    1 -> showStatisticsPerRange(position)
                    2 -> showStatisticsPerRange(position)
                }
            }

        }


        return view
    }

    private fun showStatisticsPerRange(range: Int) {
        when (range) {
            0 -> {
                tv_avarage_per_month.text = "300.2 liters"
                tv_variation.text = "4 %"
            }
            1 -> {
                tv_avarage_per_month.text = "900.2 liters"
                tv_variation.text = "3 %"
            }
            2 -> {
                tv_avarage_per_month.text = "560.0 liters"
                tv_variation.text = "2 %"
            }
            else -> {
                tv_avarage_per_month.text = "No data"
                tv_variation.text = "no Data"
            }
        }

    }

}