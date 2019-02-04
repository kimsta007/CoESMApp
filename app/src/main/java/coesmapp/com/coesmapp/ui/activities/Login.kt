package coesmapp.com.coesmapp.ui.activities

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.models.AuthModel
import coesmapp.com.coesmapp.ui.common.BaseActivity
import coesmapp.com.coesmapp.ui.home.HomeActivity
import coesmapp.com.coesmapp.ui.registration.RegistrationActivity
import coesmapp.com.coesmapp.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel


class Login : BaseActivity() {
    val TAG = "LoginActivity"

    val loginViewModel: LoginViewModel by viewModel()
    var authResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_register.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        btn_login.setOnClickListener {
            val username = tv_username.text.toString()
            val password = tv_password.text.toString()
            Log.d(TAG, "login Details are ${username} and ${password}")

            if (username.isEmpty() || password.isEmpty()) {
//                val mySnackbar = Snackbar.make(view, stringId, duration)
                Toast.makeText(this, "username and password cannot be empty", Toast.LENGTH_LONG).show()
                Log.d(TAG, "the view has to be populated")

            }

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val credentials = AuthModel(username, password)
//                authResult = loginViewModel.login(credentials)
                loginViewModel.loginLive(credentials).observe(this, Observer { result ->

                    Log.d(TAG, "in observer and the result is $result")

                    if (result == true) {
                        authResult = true
                        startActivity(Intent(this, HomeActivity::class.java))
                    }
                    if (authResult) {
                        Log.d(TAG, "in observer and the result is $result")
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
                if (!authResult) Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()



            }
        }

    }
}
