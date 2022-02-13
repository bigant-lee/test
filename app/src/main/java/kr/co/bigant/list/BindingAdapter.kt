package kr.co.bigant.list

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kr.co.bigant.list.entity.User
import kr.co.bigant.list.ui.main.TestAdapter

@BindingAdapter("bindItemList")
fun RecyclerView.bindItemList(itemList: LiveData<List<User>>) {
    (this.adapter as TestAdapter).submitList(itemList.value)
}