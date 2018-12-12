package coesmapp.com.coesmapp.ui.activities

import android.content.Intent
import android.os.Bundle
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseActivity
import coesmapp.com.coesmapp.ui.home.HomeActivity
import coesmapp.com.coesmapp.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*

class Login : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_register.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        btn_login.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }
}
