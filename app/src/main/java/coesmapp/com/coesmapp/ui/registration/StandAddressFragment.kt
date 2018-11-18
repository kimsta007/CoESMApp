package coesmapp.com.coesmapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_stand_address.view.*

class StandAddressFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stand_address, container, false)

        // set title for ToolBar
        val regToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_registration)
        regToolbar?.title = getString(R.string.stand_alone_title_label)


        view.btn_stand_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_registration_verification)
        }
        return view
    }
}