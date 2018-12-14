package coesmapp.com.coesmapp.ui.registration

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.utilities.DialogUtil
import coesmapp.com.coesmapp.utilities.setupToolbarAndTitle
import kotlinx.android.synthetic.main.fragment_verification_code.view.*

class VerificationCodeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_verification_code, container, false)

        // set title for ToolBar
        activity!!.setupToolbarAndTitle(R.id.toolbar_registration, getString(R.string.registration_verification))

        view.btn_verify_code.isEnabled = false

        view.et_verification_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.btn_verify_code.isEnabled = s?.length == 6
            }

        })

        view.btn_verify_code.setOnClickListener {

            DialogUtil.createAlertDialogWithOneButton(
                activity!!,
                "Verification Successful",
                "Phone number has been verified",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    Navigation.findNavController(it).navigate(R.id.destination_address_details)
                },
                "OK"
            ).show()
        }

        return view
    }
}