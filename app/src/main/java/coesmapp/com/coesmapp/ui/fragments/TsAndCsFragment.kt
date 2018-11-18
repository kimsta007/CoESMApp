package coesmapp.com.coesmapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_ts_and_cs.view.*

class TsAndCsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ts_and_cs, container, false)

        // set title for ToolBar
        val regToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_registration)
        regToolbar?.title = getString(R.string.ts_and_cs_title_label)

        // Load the terms and conditions from the browser
        view.wv_ts_and_cs.loadUrl("https://www.samplestore.com/legal/tnc_for_members")



        view.btn_terms_continue.isEnabled = false

        view.cb_terms_accept.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                    view.cb_terms_decline.isChecked = false
                    view.btn_terms_continue.isEnabled = true
                }
                false -> view.btn_terms_continue.isEnabled = false

            }
        }

        view.cb_terms_decline.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                view.cb_terms_accept.isChecked = false
            }
        }

        view.btn_terms_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_personal_details)
        }

        return view
    }
}