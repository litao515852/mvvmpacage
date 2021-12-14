package com.lzkhy.moble.zkhywater.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Created by lit
 * on 2021/12/14.
 * for 用于遮罩 防止点击
 */
class NotouchConstraintLayout: ConstraintLayout{

    constructor(context: Context) : super(
        context,
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context,
        attrs
    )

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }

}