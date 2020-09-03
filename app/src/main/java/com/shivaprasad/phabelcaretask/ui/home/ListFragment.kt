package com.shivaprasad.phabelcaretask.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaprasad.phabelcaretask.R
import com.shivaprasad.phabelcaretask.data.api.ContactRepository
import com.shivaprasad.phabelcaretask.data.db.AppDataBase
import com.shivaprasad.phabelcaretask.databinding.FragmentListBinding
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject


class ListFragment : Fragment() {

    @Inject
    lateinit var contactsViewModel: ContactsViewModel
    private lateinit var fragmentListBinding: FragmentListBinding

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

        fragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        fragmentListBinding.viewmodel = contactsViewModel
        fragmentListBinding.lifecycleOwner = this
        fragmentListBinding.recycleView.layoutManager = LinearLayoutManager(context)
        contactsViewModel.getData()

        return fragmentListBinding.root
    }

}