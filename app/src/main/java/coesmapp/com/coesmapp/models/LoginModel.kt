package coesmapp.com.coesmapp.models

import android.arch.persistence.room.Entity

data class LoginModel(val username: String, val password: String)

enum class Gender { MALE, FEMALE }

@Entity
data class User(
    val propertyOwner: Boolean,
    val firstName: String,
    val surname: String,
    val gender: Gender,
    val identificationNumber: String,
    val email: String,
    val phone: Int
)