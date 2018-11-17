package coesmapp.com.coesmapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_ts_and_cs.view.*

class TsAndCsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ts_and_cs, container, false)


        view.btn_terms_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_personal_details)
        }
        return view
    }
}