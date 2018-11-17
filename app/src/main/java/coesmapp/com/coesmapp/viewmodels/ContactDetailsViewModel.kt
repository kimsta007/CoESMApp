package coesmapp.com.coesmapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import coesmapp.com.coesmapp.models.PrimaryContacts

class ContactDetailsViewModel : ViewModel() {

    private val primary_email_phone: MutableLiveData<PrimaryContacts> = MutableLiveData()

    fun getPrimaryContactStatus(): LiveData<PrimaryContacts> = primary_email_phone

    fun setPrimaryConstants(primaryContacts: PrimaryContacts) {
        primary_email_phone.value = primaryContacts
    }
}