package com.example.myapplication

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.BR.user

class MyAdapter (
    val context : Context,
    val data : List<Model>
) : RecyclerView.Adapter<MyAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = RecyclerViewHolder (
        DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context), R.layout.list_item , p0 , false)

    )


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {


        data[p1].let {
                val bindingSuccess = p0.bind.setVariable(user,it)
                p0.bind.executePendingBindings()
                if (!bindingSuccess) {
                    throw IllegalStateException("Binding ${p0.bind} viewModel variable name should be 'viewModel'")
                }
            }
    }

    class RecyclerViewHolder(binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }


}