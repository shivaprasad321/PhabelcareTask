package com.shivaprasad.phabelcaretask.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shivaprasad.phabelcaretask.R
import com.shivaprasad.phabelcaretask.data.entities.ContactDataEntity
import com.shivaprasad.phabelcaretask.databinding.FragmentAddandEditBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class AddandEditFragment : Fragment() {

    @Inject
    lateinit var contactsViewModel: ContactsViewModel

    lateinit var data: ContactDataEntity

    private lateinit var fragmentAddandEditBinding :FragmentAddandEditBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAddandEditBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_addand_edit, container, false)

        fragmentAddandEditBinding.viewmodel = contactsViewModel
        fragmentAddandEditBinding.lifecycleOwner = this

        if(requireArguments().containsKey("data")){
            arguments?.let {
                data = it.getSerializable("data") as ContactDataEntity
                contactsViewModel.updateUI(data)
                contactsViewModel.addbtn.value = false
                contactsViewModel.updatebtn.value = true
                contactsViewModel.deletebtn.value = true
                fragmentAddandEditBinding.entity = data

            }
        }else{
            contactsViewModel.updateUI(ContactDataEntity("",""))
            contactsViewModel.addbtn.value = true
            contactsViewModel.updatebtn.value = false
            contactsViewModel.deletebtn.value = false
        }

        return fragmentAddandEditBinding.root
    }
}