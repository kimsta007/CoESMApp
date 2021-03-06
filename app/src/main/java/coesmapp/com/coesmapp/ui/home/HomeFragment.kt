package coesmapp.com.coesmapp.ui.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val registrationViewModel: RegistrationViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // set support toolbar title extension function
        activity!!.setupToolbarAndTitle(R.id.toolbar_home, "Home")

        observeUserProfile()

        view.btn_meter_reading_schedule.setOnClickListener {
            //            Navigation.findNavController(it).navigate(R.id.destination_reading_schedule)
            startActivity(Intent(activity!!, MeterReadingScheduleActivity::class.java))
        }

        view.btn_capture_meter_reading.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_capture_reading)
        }

        view.btn_reading_objections.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_reading_objection)
        }

        view.btn_reports.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_reports)
        }

        return view
    }

    private fun observeUserProfile() {
        registrationViewModel.getProfileData().observe(this, Observer {profile ->
            profile?.let{
                tv_home_full_name.text = "${it.firstName} ${it.surname}"
            }

        })
    }
}