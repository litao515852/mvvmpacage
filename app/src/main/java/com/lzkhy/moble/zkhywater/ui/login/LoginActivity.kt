package com.lzkhy.moble.zkhywater.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import com.lzkhy.moble.zkhywater.R
import com.lzkhy.moble.zkhywater.databinding.ActivityLoginBinding
import com.lzkhy.moble.zkhywater.ui.base.BaseActivity
import com.skydoves.bindables.BindingActivity
import com.skydoves.transformationlayout.onTransformationEndContainer
import com.skydoves.transformationlayout.onTransformationStartContainer
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login){

    @Inject
    lateinit var loginViewModelFactory:LoginViewModel.AssistedFactory

    val viewModel:LoginViewModel by viewModels{
        LoginViewModel.provideFactory(loginViewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding{
            vm = viewModel
        }

    }
}