package kr.co.bigant.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.bigant.list.databinding.TestListItemBinding
import kr.co.bigant.list.view.base.BaseAdapter


class TestAdapter(diffUtil: DiffUtil.ItemCallback<String>) :
    BaseAdapter<String>(diffUtil) {
    //베이스 어뎁터로 만들기 숙제!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = TestListItemBinding.inflate(LayoutInflater.from(parent.context))
        return TestViewHolder(binding as TestListItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TestViewHolder) {
            holder.onBind(getItem(position).toString())
        }
    }

    class TestViewHolder(private val binding: TestListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: String) {
            binding.text1.text = item
        }
    }
}