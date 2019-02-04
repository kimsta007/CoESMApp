package coesmapp.com.coesmapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import coesmapp.com.coesmapp.models.room.UserAddressEntity
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import coesmapp.com.coesmapp.repository.RegistrationRepository

class RegistrationViewModel(private val repository: RegistrationRepository) : ViewModel() {

    private lateinit var userProfile: MutableLiveData<UserProfileEntity>
    private lateinit var address: UserAddressEntity

    fun addUserProfile(profile: UserProfileEntity) = repository.addUserProfile(profile)

    fun getUserProfile(): LiveData<UserProfileEntity> = repository.getUserProfile()

    // new database observer class
    fun getProfileData(): LiveData<UserProfileEntity> {
        return repository.getProfileData()
    }

    fun getUserAddress(): LiveData<UserAddressEntity> = repository.getUserAddress()


    fun saveUserAddress(address: UserAddressEntity) = repository.saveUserAddress(address)

    fun getUserProfileTwo(): LiveData<UserProfileEntity> {
        if (!::userProfile.isInitialized) {
            userProfile = MutableLiveData()
            loadProfile()
        }
        return userProfile
    }

    private fun loadProfile() {
        userProfile = repository.getUserProfile() as MutableLiveData<UserProfileEntity>
    }

    fun getUserProfileNonLive(): UserProfileEntity = repository.getUserProfileNonLive()
}