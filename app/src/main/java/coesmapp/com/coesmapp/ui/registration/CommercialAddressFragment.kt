package coesmapp.com.coesmapp.ui.registration

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.models.room.UserAddressEntity
import coesmapp.com.coesmapp.ui.activities.Login
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_commercial_address.*
import kotlinx.android.synthetic.main.fragment_commercial_address.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class CommercialAddressFragment : BaseFragment() {

    private val registrationViewModel: RegistrationViewModel by viewModel()
    private lateinit var addressDetails:UserAddressEntity

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        registrationViewModel.getUserAddress().observe(this, Observer {address ->
            address?.let{
                addressDetails = it.copy()
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_commercial_address, container, false)

        // set title for ToolBar

        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.commecial_address_title_label))

        // initialise the address variable
//        addressDetails = registrationViewModel.getUserAddress().copy()

        view.btn_commecial_continue.setOnClickListener {
            saveUserAddress()
            startActivity(Intent(activity, Login::class.java))
        }

        return view
    }

    private fun saveUserAddress(){
        addressDetails.postalCode = ti_comm_postal_code.text.toString()
        addressDetails.street = ti_comm_street_name.text.toString()
        addressDetails.provice = ti_comm_province.text.toString()
        addressDetails.streetNumber = ti_comm_street_number.text.toString()
        addressDetails.streetNumber = ti_comm_suburb.text.toString()
        registrationViewModel.saveUserAddress(addressDetails)

    }


}