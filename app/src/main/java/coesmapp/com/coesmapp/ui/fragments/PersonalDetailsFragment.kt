package coesmapp.com.coesmapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_personal_details.*
import kotlinx.android.synthetic.main.fragment_personal_details.view.*

class PersonalDetailsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_details, container, false)

        // set title for ToolBar
        val regToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_registration)
        regToolbar?.title = getString(R.string.personal_details_title_label)


        view.btn_personal_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_contact_details)
        }

        view.cb_gender_female.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) view.cb_gender_male.isChecked = false
        }

        view.cb_gender_male.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) view.cb_gender_female.isChecked = false
        }

        return view
    }
}