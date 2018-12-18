package coesmapp.com.coesmapp.ui.home.meter_reading_fragmants

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import kotlinx.android.synthetic.main.fragment_agent_details.view.*

class AgentDetailsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_agent_details, container, false)

        rootView.apply {
            tv_agent_name.text = "Trust Mubaiwa"
            tv_agent_number.text = "123456789"
            tv_veh_reg_number.text = "ABV-123 GP"
            tv_vehicle_make.text = "Toyota"
            tv_vehicle_color.text = "Blue"
        }

        return rootView
    }

    override fun onResume() {
        super.onResume()
        Log.d("AgentDetailsFragment", "Fragment Started")
        activity!!.setupToolbarAndTitle(R.id.toolbar_reading_schedule, "Agent Details")
    }
    /*  companion object {
          /**
           * The fragment argument representing the section number for this
           * fragment.
           */
          private val ARG_SECTION_NUMBER = "section_number"

          /**
           * Returns a new instance of this fragment for the given section
           * number.
           */
          fun newInstance(sectionNumber: Int): AgentDetailsFragment {
              val fragment = AgentDetailsFragment()
              val args = Bundle()
              args.putInt(ARG_SECTION_NUMBER, sectionNumber)
              fragment.arguments = args
              return fragment
          }
      }
      */
}