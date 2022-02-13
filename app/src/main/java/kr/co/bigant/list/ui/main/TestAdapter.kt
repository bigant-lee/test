package kr.co.bigant.list.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.co.bigant.list.databinding.TestListItemBinding
import kr.co.bigant.list.base.BaseAdapter
import kr.co.bigant.list.entity.User


class TestAdapter(diffUtil: DiffUtil.ItemCallback<User>) :
    BaseAdapter<User>(diffUtil) {

    //베이스 어뎁터로 만들기 숙제!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = TestListItemBinding.inflate(LayoutInflater.from(parent.context))
        return TestViewHolder(binding as TestListItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TestViewHolder) {
            holder.onBind(getItem(position))
        }
    }

    inner class TestViewHolder(private val binding: TestListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: User) {
            if (binding is TestListItemBinding) {
                binding.apply {
                    binding.text1.text = item.firstName
                    root.setOnClickListener {
                        onClick(item)
                    }
                }
            }
        }
    }
}