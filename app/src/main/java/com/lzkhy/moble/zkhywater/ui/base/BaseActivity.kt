package com.lzkhy.moble.zkhywater.ui.base

import androidx.databinding.ViewDataBinding
import com.skydoves.bindables.BindingActivity

open class BaseActivity<T: ViewDataBinding>(contentLayoutId: Int) :BindingActivity<ViewDataBinding>(contentLayoutId){

}