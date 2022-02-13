package kr.co.bigant.list.base


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, RecyclerView.ViewHolder>(diffCallback) {
    protected lateinit var binding: ViewDataBinding
    protected lateinit var onClick: (Any) -> Unit
    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    fun addOnClickListener(onClick: (Any) -> Unit) {
        this.onClick = onClick
    }
}