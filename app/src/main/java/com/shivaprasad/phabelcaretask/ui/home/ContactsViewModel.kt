package com.shivaprasad.phabelcaretask.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.shivaprasad.phabelcaretask.R
import com.shivaprasad.phabelcaretask.data.api.ContactRepository
import com.shivaprasad.phabelcaretask.data.api.Coroutines
import com.shivaprasad.phabelcaretask.data.entities.ContactDataEntity
import javax.inject.Inject


class ContactsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var newsRepository: ContactRepository

    lateinit var employeesDataEntityFromDB: List<ContactDataEntity>
    var dataEntityFromDB: List<ContactDataEntity> = ArrayList<ContactDataEntity>()

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var addbtn = MutableLiveData<Boolean>()
    var updatebtn = MutableLiveData<Boolean>()
    var deletebtn = MutableLiveData<Boolean>()


    var adapter = RecycleAdapter(
        R.layout.recycle_item,
        dataEntityFromDB,
        this
    )

    fun updateUI(contactDataEntity: ContactDataEntity?) {
        name.value = contactDataEntity!!.name
        email.value = contactDataEntity.emailid
    }

    fun setAdapter(): RecycleAdapter {
        return adapter
    }

    fun onDetailClick(view: View, position: Int) {

        val bundle = Bundle()
        bundle.putSerializable("data", employeesDataEntityFromDB[position])


        Navigation.findNavController(view)
            .navigate(R.id.action_listFragment_to_addandEditFragment, bundle)


    }

    fun onAddClick(view: View) {

        val bundle = Bundle()
        bundle.putSerializable("str", "")

        Navigation.findNavController(view)
            .navigate(R.id.action_listFragment_to_addandEditFragment, bundle)
    }

    fun entity(position: Int): ContactDataEntity {
        return employeesDataEntityFromDB[position]
    }


    fun addData(view: View) {

        Coroutines.main {
            newsRepository.saveEmployeesData(ContactDataEntity(name.value!!, email.value!!))
        }
        Navigation.findNavController(view).navigate(R.id.action_addandEditFragment_to_listFragment)
    }

    fun deletData(view: View, contactDataEntity: ContactDataEntity) {

        Coroutines.main {
            newsRepository.delete(contactDataEntity)
        }
        Navigation.findNavController(view).navigate(R.id.action_addandEditFragment_to_listFragment)

    }

    fun updateData(view: View, contactDataEntity: ContactDataEntity) {

        contactDataEntity.name = name.value!!
        contactDataEntity.emailid = email.value!!

        Coroutines.main {
            newsRepository.update(contactDataEntity)
        }

        Navigation.findNavController(view).navigate(R.id.action_addandEditFragment_to_listFragment)

    }

    fun getData() {
        Coroutines.main {
            employeesDataEntityFromDB = newsRepository.getAllEmployesData()
            adapter.updateData(employeesDataEntityFromDB)
        }
    }
}