package com.lzkhy.moble.zkhywater.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.lzkhy.moble.zkhywater.R
import com.lzkhy.moble.zkhywater.extensions.onTransformationEndContainerApplyParams
import com.skydoves.bindables.BindingActivity
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

open class BaseActivity<T>(contentLayoutId: Int) :BindingActivity<ViewDataBinding>(contentLayoutId){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}