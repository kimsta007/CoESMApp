package coesmapp.com.coesmapp.ui.home

import android.os.Bundle
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar_home)
    }
}
