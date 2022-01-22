package kr.co.bigant.list

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.bigant.list.view.TestAdapter

@BindingAdapter("bindItemList")
fun RecyclerView.bindItemList(itemList: List<String>) {
    (this.adapter as TestAdapter).submitList(itemList)
}