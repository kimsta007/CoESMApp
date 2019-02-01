package coesmapp.com.coesmapp.ui.registration

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.displaySpinner
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_personal_details.*
import kotlinx.android.synthetic.main.fragment_personal_details.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class PersonalDetailsFragment : BaseFragment() {

    private val registrationViewModel: RegistrationViewModel by viewModel()
    lateinit var personalRecord: UserProfileEntity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        registrationViewModel.getUserProfile().observe(this, Observer { userProfileEntity ->
            userProfileEntity?.let {
                personalRecord = it.copy()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_details, container, false)

        // set title for ToolBar
        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.personal_details_title_label))

        // Setup the spinner values for
        view.spinner_owner_tenant.displaySpinner(this.activity!!, R.array.property_ownership)
        view.spinner_preferred_method.displaySpinner(this.activity!!, R.array.contact_preference)


        view.cb_gender_female.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) view.cb_gender_male.isChecked = false
        }

        view.cb_gender_male.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) view.cb_gender_female.isChecked = false
        }

        view.btn_personal_continue.isEnabled = false

        view.ti_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                view.btn_personal_continue.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    view.btn_personal_continue.isEnabled = s.length == 10
                }
            }
        })

//        personalRecord = registrationViewModel.getUserProfileNonLive().copy()

        view.btn_personal_continue.setOnClickListener {
            savePersonalDetails(personalRecord)
            Navigation.findNavController(it).navigate(R.id.destination_contact_details)
        }

        return view
    }


    private fun savePersonalDetails(personal: UserProfileEntity) {

        val ownerSpinnerValue = spinner_owner_tenant?.selectedItem?.toString()
        personalRecord.propertyOwner = ownerSpinnerValue == "Owner"
        personalRecord.firstName = ti_firstname.text.toString()
        personalRecord.surname = ti_surname.text.toString()
        personalRecord.gender = if (cb_gender_female.isChecked) "Female" else "Male"
        personalRecord.identificationNumber = ti_id_passport_number.text.toString()
        personalRecord.phone = ti_phone.text.toString().toInt()
        personalRecord.email = ti_email.text.toString()
        val methodSpinnerValue = spinner_preferred_method?.selectedItem?.toString()
        personalRecord.preferMethod = methodSpinnerValue

        registrationViewModel.addUserProfile(personal)
    }
}