package coesmapp.com.coesmapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.activities.common.BaseActivity

class Login : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
