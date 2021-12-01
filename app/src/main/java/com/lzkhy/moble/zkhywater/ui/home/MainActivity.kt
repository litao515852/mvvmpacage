package com.lzkhy.moble.zkhywater.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lzkhy.moble.zkhywater.R
import com.lzkhy.moble.zkhywater.ui.base.BaseActivity
import com.skydoves.transformationlayout.onTransformationStartContainer
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()
        setContentView(R.layout.activity_main)

    }
}