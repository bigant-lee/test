package kr.co.bigant.list.view.base


import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter(diffUtil: DiffUtil.ItemCallback<Any>) :
    ListAdapter<Any, RecyclerView.ViewHolder>(diffUtil) {
    protected lateinit var binding: ViewDataBinding
    override fun getItemCount(): Int {
        return super.getItemCount()
    }
}