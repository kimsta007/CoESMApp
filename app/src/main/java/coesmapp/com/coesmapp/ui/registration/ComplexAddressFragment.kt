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
import kotlinx.android.synthetic.main.fragment_comeplex_address.*
import kotlinx.android.synthetic.main.fragment_comeplex_address.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ComplexAddressFragment : BaseFragment() {

    private val registrationViewModel: RegistrationViewModel by viewModel()
    private lateinit var addressDetails: UserAddressEntity

    override fun onAttach(context: Context?) {
        super.onAttach(context)

//        registrationViewModel.getUserAddress().observe(this, Observer { address ->
//            addressDetails = address?.copy()!!
//        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_comeplex_address, container, false)

        // set title for ToolBar

        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.complex_address_title_label))

//        addressDetails = registrationViewModel.getUserAddress().copy()

        registrationViewModel.getUserAddress().observe(this, Observer { address ->
            address?.let {
                addressDetails = it.copy()
            }

        })

        view.btn_complex_continue.setOnClickListener {
            //            Navigation.findNavController(it)

            registrationViewModel.getUserAddress().observe(this, Observer { address ->
                address?.let {
                    addressDetails = it.copy()
                    saveAddressDetails()

                }

            })
//            saveAddressDetails()
            startActivity(Intent(activity, Login::class.java))
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrationViewModel.getUserAddress().observe(this, Observer { address ->
            address?.let {
                addressDetails = it.copy()
            }

        })
    }


    private fun saveAddressDetails() {
        addressDetails.complexName = ti_complex_name.text.toString()
        addressDetails.unit = ti_complex_unit_number.text.toString()
        addressDetails.street = ti_complex_street_name.text.toString()
        addressDetails.suburb = ti_complex_suburb.text.toString()
        addressDetails.postalCode = ti_complex_postal_code.text.toString()

        registrationViewModel.saveUserAddress(addressDetails)
    }


}