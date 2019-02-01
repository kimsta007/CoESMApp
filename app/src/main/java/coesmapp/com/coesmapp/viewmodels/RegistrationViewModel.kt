package coesmapp.com.coesmapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import coesmapp.com.coesmapp.repository.RegistrationRepository

class RegistrationViewModel(private val repository: RegistrationRepository) : ViewModel() {

    fun addUserProfile(profile: UserProfileEntity)= repository.addUserProfile(profile)

    fun getUserProfile(): LiveData<UserProfileEntity> = repository.getUserProfile()

    fun getUserProfileNonLive(): UserProfileEntity = repository.getUserProfileNonLive()
}