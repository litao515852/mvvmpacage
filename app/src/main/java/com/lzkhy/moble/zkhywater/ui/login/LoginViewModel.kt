package com.lzkhy.moble.zkhywater.ui.login

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.lzkhy.moble.zkhywater.repository.LoginRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.FlowBindingPropertyIdWithDefaultValueOnScope
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty

/**
 * Created by lit
 * on 2021/11/25.
 * for
 */
class LoginViewModel constructor(
  var loginRepository: LoginRepository
) : BindingViewModel() {

    @get:Bindable
    var showPass : Boolean by bindingProperty(false)

    fun login( name: String,
               password:String):FlowBindingPropertyIdWithDefaultValueOnScope<String?> {
        return loginRepository.login(name, password).asBindingProperty(viewModelScope,"")
    }


//    companion object {
//        fun provideFactory(
//            assistedFactory: AssistedFactory,
//            pokemonName: String
//        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return assistedFactory.create(pokemonName) as T
//            }
//        }
//    }
}