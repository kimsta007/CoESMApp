package coesmapp.com.coesmapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle

class RegistrationVerificationFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration_verification, container, false)

        // set title for ToolBar
        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.registration_verification))

        return view
    }
}