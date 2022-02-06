package kr.co.bigant.list.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.co.bigant.list.db.AppDatabase

abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {
    protected lateinit var binding: VDB
    protected lateinit var appDataBase : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<VDB>(this, layoutRes).apply {
            lifecycleOwner = this@BaseActivity
        }

    }
}