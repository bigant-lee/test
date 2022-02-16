package kr.co.bigant.list.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.bigant.list.R
import kr.co.bigant.list.databinding.ActivityMainBinding
import kr.co.bigant.list.base.BaseActivity
import kr.co.bigant.list.db.dao.UserDao
import kr.co.bigant.list.entity.User
import kr.co.bigant.list.repository.TestRepository
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    @Inject
    lateinit var userDao: UserDao
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {

        }
        binding.vm = mainViewModel
        val diffUtil = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem == newItem
            }
        }
        val testAdapter = TestAdapter(diffUtil)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = testAdapter
        mainViewModel.getData()

    }
}