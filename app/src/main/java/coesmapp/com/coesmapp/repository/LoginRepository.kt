package coesmapp.com.coesmapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import coesmapp.com.coesmapp.models.AuthModel
import coesmapp.com.coesmapp.models.room.UserProfileDao
import java.util.concurrent.ExecutorService

class LoginRepository(private val userProfileDao: UserProfileDao, private val executor: ExecutorService) {

//    private val authorised: MutableLiveData<Boolean> = MutableLiveData()


    fun login(user: AuthModel): Boolean {
        var authorised = false
        executor.execute {
            val userProfile = userProfileDao.getUserProfile()
            userProfile?.let {
                if (user.username == userProfile.email && user.password == userProfile.password) {
                    authorised = true
                }
            }
        }

        return authorised

    }

    fun loginLive(user: AuthModel): LiveData<Boolean>  {
        val authorised: MutableLiveData<Boolean> = MutableLiveData()
//        authorised.postValue(false)
        executor.execute {
            val userProfile = userProfileDao.getUserProfile()
//            authorised.postValue(false)
            userProfile?.let {
                if (user.username == userProfile.email && user.password == userProfile.password) {
                    authorised.postValue(true)
                }
            }
        }
        return authorised
    }
}