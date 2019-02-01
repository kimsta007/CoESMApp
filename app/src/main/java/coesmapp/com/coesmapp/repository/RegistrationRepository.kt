package coesmapp.com.coesmapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import coesmapp.com.coesmapp.models.room.UserProfileDao
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import java.util.concurrent.ExecutorService

class RegistrationRepository(private val userProfileDao: UserProfileDao, private val executorService: ExecutorService) {

    fun getUserProfile(): LiveData<UserProfileEntity> {
        val result: MutableLiveData<UserProfileEntity> = MutableLiveData()
        executorService.execute {
            result.postValue(userProfileDao.getUserProfile())
        }
        return result
    }

    fun getUserProfileNonLive(): UserProfileEntity {
        var result: UserProfileEntity = userProfileDao.getUserProfile()
        executorService.execute {
            result = userProfileDao.getUserProfile()
        }
        return result
    }

    fun addUserProfile(profile: UserProfileEntity) {
        executorService.execute {
            userProfileDao.insertUser(profile)
        }
    }
}