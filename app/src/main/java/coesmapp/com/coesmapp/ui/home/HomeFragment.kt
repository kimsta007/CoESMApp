package coesmapp.com.coesmapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseFragment
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // set title for ToolBar
        val homeToolbar = activity?.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_home)
        homeToolbar?.title = "Home"

        return view
    }
}