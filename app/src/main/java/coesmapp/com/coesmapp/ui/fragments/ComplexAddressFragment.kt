package coesmapp.com.coesmapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment

class ComplexAddressFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_comeplex_address, container, false)

        return view
    }
}