package com.shivaprasad.phabelcaretask.ui.home
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shivaprasad.phabelcaretask.BR
import com.shivaprasad.phabelcaretask.data.entities.ContactDataEntity

class RecycleAdapter(@LayoutRes val layoutid: Int, var data : List<ContactDataEntity>, val viewmodel: ContactsViewModel): RecyclerView.Adapter<RecycleAdapter.GenericViewModel>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewModel {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,viewType,parent,false)

        return GenericViewModel(
            binding
        )

    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: GenericViewModel, position: Int) {
        holder.bind(viewmodel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return layoutid
    }

    class GenericViewModel (private var binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(viewmodel: ContactsViewModel, position: Int){

            binding.setVariable(BR.itemViewmodel,viewmodel)
            binding.setVariable(BR.position,position)
        }

    }

    fun updateData(articalsData:List<ContactDataEntity>){
        this.data = articalsData
        notifyDataSetChanged()
    }

}