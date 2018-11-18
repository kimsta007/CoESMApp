package coesmapp.com.coesmapp.ui.registration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseActivity

class RegistrationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        setSupportActionBar(findViewById(R.id.toolbar_registration))

    }
}
