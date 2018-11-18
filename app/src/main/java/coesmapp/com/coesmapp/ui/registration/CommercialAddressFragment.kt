package coesmapp.com.coesmapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment

class CommercialAddressFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_commercial_address, container, false)

        // set title for ToolBar
        val regToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_registration)
        regToolbar?.title = getString(R.string.commecial_address_title_label)


        return view
    }
}