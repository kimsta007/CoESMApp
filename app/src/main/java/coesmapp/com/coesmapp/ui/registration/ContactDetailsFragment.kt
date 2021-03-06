package coesmapp.com.coesmapp.ui.registration

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.models.PrimaryContacts
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.DialogUtil
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import coesmapp.com.coesmapp.viewmodels.ContactDetailsViewModel
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_contact_details.*
import kotlinx.android.synthetic.main.fragment_contact_details.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class ContactDetailsFragment : BaseFragment() {

    private val contactViewModel: ContactDetailsViewModel by viewModel()
    private val registrationViewModel: RegistrationViewModel by viewModel()
    private lateinit var personalRecord: UserProfileEntity

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        registrationViewModel.getUserProfile().observe(this, Observer { userProfileEntity ->
            userProfileEntity?.let {
                personalRecord = it.copy()
            }

        })

        registrationViewModel.getProfileData().observe(this, Observer { profile ->
            profile?.let {
                personalRecord = it.copy()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contact_details, container, false)

        // set title for ToolBar
        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.contact_details_title_label))


        view.btn_contact_continue.isEnabled = false
        var primaryCont: PrimaryContacts = PrimaryContacts(false, false)

        /**
         * only one of the radio buttons can be selected for phone number.
         * the continue button is enabled.
         */
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

        /**
         * Update the phone number using a alertDialog
         *
         */
        view.rb_new_primary_phone.setOnClickListener {
            val input = EditText(activity!!)
            input.inputType = InputType.TYPE_CLASS_PHONE or InputType.TYPE_TEXT_VARIATION_PHONETIC

            DialogUtil.createAlertDialogWithTextInputAndTwoButtons(
                activity!!,
                "New Primary Phone",
                "Enter a new primary phone number.",
                "Update",
                DialogInterface.OnClickListener { dialog, which ->
                    if (input.text.isEmpty()) {
                        dialog.dismiss()
                    } else {
                        view.tv_contacts_cell_number.text = input.text.toString()
                        personalRecord.phone = input.text.toString().toInt()
                        registrationViewModel.addUserProfile(personalRecord)

                    }
                    // update the database with the new value
                    dialog.dismiss()
                },
                "Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                }, input
            ).show()
        }

        /**
         * update the email address using a AlertDialog
         */
        view.rb_new_primary_email.setOnClickListener {
            val input = EditText(activity!!)
            input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

            DialogUtil.createAlertDialogWithTextInputAndTwoButtons(
                activity!!,
                "New Primary Email",
                "Enter a new primary email address.",
                "Update",
                DialogInterface.OnClickListener { dialog, which ->
                    if (input.text.isEmpty()) {
                        dialog.dismiss()
                    } else {
                        view.tv_contact_email_address.text = input.text.toString()
                        personalRecord.email = input.text.toString()
                        registrationViewModel.addUserProfile(personalRecord)
                        dialog.dismiss()
                    }
                    // update the database with the new value
                    dialog.dismiss()
                },
                "Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                }, input
            ).show()
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

        /**
         * an observable for all the required primary values have been set in order to continue.
         */
        contactViewModel.getPrimaryContactStatus().observe(this, Observer {
            println("State of email in Observer ${it?.emailSet}")
            println("State of phone in Observer ${it?.phoneSet}")
            initialiseValues()

            it?.let { pc ->
                view.btn_contact_continue.isEnabled = pc.emailSet && pc.phoneSet
            }
        })

        view.btn_contact_continue.setOnClickListener {
            personalRecord.password = "password"
            savePersonalRecord(personalRecord)
            //            Navigation.findNavController(it).navigate(R.id.destination_address_details)
            Navigation.findNavController(it).navigate(R.id.destination_verification_code)
        }

        // Observers
        observeDatabaseChanges()

        return view
    }

    private fun savePersonalRecord(record: UserProfileEntity) {
        registrationViewModel.addUserProfile(record)
    }

    private fun initialiseValues() {
        tv_contacts_cell_number.text = personalRecord.phone.toString()
        tv_contact_email_address.text = personalRecord.email.toString()
    }

    override fun onDetach() {
        super.onDetach()
        contactViewModel.getPrimaryContactStatus().removeObservers(this)
    }

    private fun observeDatabaseChanges() {
        registrationViewModel.getProfileData().observe(this, Observer { profile ->
            profile?.let {
                tv_contacts_cell_number.text = it.phone.toString()
                tv_contact_email_address.text = it.email
            }

        })
    }
}