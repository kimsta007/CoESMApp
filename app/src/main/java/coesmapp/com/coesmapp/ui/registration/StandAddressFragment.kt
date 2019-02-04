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
import kotlinx.android.synthetic.main.fragment_stand_address.*
import kotlinx.android.synthetic.main.fragment_stand_address.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class StandAddressFragment : BaseFragment() {

    private val registrationViewModel: RegistrationViewModel by viewModel()
    private lateinit var addressDetails: UserAddressEntity

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        registrationViewModel.getUserAddress().observe(this, Observer { address ->
            address?.let {
                addressDetails = it.copy()
            }
        })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stand_address, container, false)

        // set title for ToolBar
        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.stand_alone_title_label))

//        addressDetails = registrationViewModel.getUserAddress().copy()

        view.btn_stand_continue.setOnClickListener {
            //            Navigation.findNavController(it).navigate(R.id.destination_registration_verification)
            saveUserAddress()
            startActivity(Intent(activity, Login::class.java))
        }
        return view
    }

    private fun saveUserAddress() {
        addressDetails.provice = ti_stand_province.text.toString()
        addressDetails.streetNumber = ti_stand_house_number.text.toString()
        addressDetails.postalCode = ti_stand_postal_code.text.toString()
        addressDetails.suburb = ti_stand_suburb.text.toString()

        registrationViewModel.saveUserAddress(addressDetails)

    }
}