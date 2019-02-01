package coesmapp.com.coesmapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import coesmapp.com.coesmapp.models.AuthModel
import coesmapp.com.coesmapp.repository.LoginRepository

class LoginViewModel(val repository: LoginRepository) : ViewModel() {

    fun login(user: AuthModel): Boolean = repository.login(user)
    fun loginLive(user: AuthModel): LiveData<Boolean> = repository.loginLive(user)

}