package com.lzkhy.moble.zkhywater.ui.login

import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.lzkhy.moble.zkhywater.repository.LoginRepository
import com.lzkhy.moble.zkhywater.utils.ToastUtils
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.FlowBindingPropertyIdWithDefaultValueOnScope
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by lit
 * on 2021/11/25.
 * for
 */
class LoginViewModel @AssistedInject constructor(
  var loginRepository: LoginRepository
) : BindingViewModel() {

    @get:Bindable
    var userName :String by bindingProperty("")

    @get:Bindable
    var password :String by bindingProperty("")

    @get:Bindable
    var showPass : Boolean by bindingProperty(false)

    @get:Bindable
    var loading : Boolean by bindingProperty(false)
        private set

    fun login() {
        if(userName.isEmpty()){
            ToastUtils.showToast("请输入手机号码")
            return
        }
        if(password.isEmpty()){
            ToastUtils.showToast("请输入密码")
            return
        }

//        loginRepository.login(userName, password)

        //
        GlobalScope.launch {
            loading = true
            var isSuss =loginRepository.login(
                userName,
                password,

            )

            withContext(Dispatchers.Main){
                loading = false
                if(isSuss){
                    ToastUtils.showToast("登录成功")
                }
            }
        }

    }

//    private val pokemonListFlow = loginRepository.login(
//        "name = pokemonName,",
//        "1",
//        onComplete = { },
//    )
//
//    @get:Bindable
//    val pokemonList: String by pokemonListFlow.asBindingProperty(viewModelScope, "")



    fun onPasswordShow(){
        showPass = !showPass
    }

    @dagger.assisted.AssistedFactory
    interface AssistedFactory {
        fun create(): LoginViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create() as T
            }
        }
    }
}