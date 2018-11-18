package coesmapp.com.coesmapp.ui.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.models.PrimaryContacts
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.viewmodels.ContactDetailsViewModel
import kotlinx.android.synthetic.main.fragment_contact_details.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ContactDetailsFragment : BaseFragment() {

    private val contactViewModel: ContactDetailsViewModel by viewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contact_details, container, false)

        // set title for ToolBar
        val regToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_registration)
        regToolbar?.title = getString(R.string.contact_details_title_label)


        view.btn_contact_continue.isEnabled = false
        var primaryCont: PrimaryContacts = PrimaryContacts(false, false)

        view.rb_primary_phone_number.setOnCheckedChangeListener { _, isChecked ->
            println("State changed to : $isChecked")

            when (isChecked) {
                true -> {
                    primaryCont = primaryCont.copy(phoneSet = true)
                    contactViewModel.setPrimaryConstants(primaryCont)

                }
                false -> {
                    primaryCont = primaryCont.copy(phoneSet = false)
                    contactViewModel.setPrimaryConstants(primaryCont)
                }
            }
        }

        view.rb_primary_email_address.setOnCheckedChangeListener { _, isChecked ->
            println("State changed to : $isChecked")
            when (isChecked) {
                true -> {
                    primaryCont = primaryCont.copy(emailSet = true)
                    contactViewModel.setPrimaryConstants(primaryCont)
                }
                false -> {
                    primaryCont = primaryCont.copy(emailSet = false)
                    contactViewModel.setPrimaryConstants(primaryCont)

                }
            }
        }

        contactViewModel.getPrimaryContactStatus().observe(this, Observer {
            println("State of email in Observer ${it?.emailSet}")
            println("State of phone in Observer ${it?.phoneSet}")

            it?.let {
                view.btn_contact_continue.isEnabled = it.emailSet && it.phoneSet
            }
        })

        view.btn_contact_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.destination_address_details)
        }

        return view
    }
}