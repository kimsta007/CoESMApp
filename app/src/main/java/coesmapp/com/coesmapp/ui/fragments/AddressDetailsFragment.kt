package coesmapp.com.coesmapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_address_details.view.*

class AddressDetailsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_address_details, container, false)



        view.btn_address_complex.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_complex_address)
        }

        view.btn_address_stand_alone.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_stand_address)
        }

        view.btn_address_commecial.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_commecial_address)
        }


        view.btn_address_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_registration_verification)
        }


        return view
    }
}