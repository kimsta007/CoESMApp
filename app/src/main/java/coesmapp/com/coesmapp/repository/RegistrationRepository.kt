package coesmapp.com.coesmapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import coesmapp.com.coesmapp.models.room.UserProfileDao
import coesmapp.com.coesmapp.models.room.UserProfileEntity
import java.util.concurrent.ExecutorService
import android.os.AsyncTask
import coesmapp.com.coesmapp.models.room.UserAddressDao
import coesmapp.com.coesmapp.models.room.UserAddressEntity


class RegistrationRepository(
    private val userProfileDao: UserProfileDao,
    private val userAddressDao: UserAddressDao,
    private val executorService: ExecutorService
) {

    private lateinit var getUserProfileData: LiveData<UserProfileEntity>
    private lateinit var userAddress: UserAddressEntity

    fun getUserProfile(): LiveData<UserProfileEntity> {
        val result: MutableLiveData<UserProfileEntity> = MutableLiveData()
        executorService.execute {
            result.postValue(userProfileDao.getUserProfile())
        }
        return result
    }

    fun getProfileData(): LiveData<UserProfileEntity> {
        getUserProfileData = userProfileDao.getUserProfileData()
        return getUserProfileData
    }

//    fun insert(word: UserProfileEntity) {
//        insertAsyncTask(mWordDao).execute(word)
//    }

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


    fun getUserAddress(): LiveData<UserAddressEntity> {
        val result: MutableLiveData<UserAddressEntity> = MutableLiveData()
        executorService.execute {
            result.postValue(userAddressDao.getUserAddress())
        }
        return result

    }

    fun saveUserAddress(address: UserAddressEntity) {
        executorService.execute {
            userAddressDao.insertAddress(address)
        }

    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserProfileDao) :
        AsyncTask<UserProfileEntity, Void, Void>() {

        override fun doInBackground(vararg params: UserProfileEntity): Void? {
            mAsyncTaskDao.insertUser(params[0])
            return null
        }
    }
}