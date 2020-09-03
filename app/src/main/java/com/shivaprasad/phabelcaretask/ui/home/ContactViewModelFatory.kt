package com.shivaprasad.phabelcaretask.ui.home

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shivaprasad.phabelcaretask.data.api.ContactRepository
import javax.inject.Inject
import javax.inject.Singleton


@Suppress("UNCHECKED_CAST")
@Singleton
class ContactViewModelFatory @Inject constructor (): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ContactsViewModel::class.java!!)) {
            ContactsViewModel(
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}