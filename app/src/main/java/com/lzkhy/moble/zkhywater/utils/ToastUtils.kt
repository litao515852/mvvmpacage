package com.lzkhy.moble.zkhywater.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.lzkhy.moble.zkhywater.MyApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.internal.aggregatedroot.codegen._com_lzkhy_moble_zkhywater_MyApp
import javax.inject.Inject

/**
 * Created by lit
 * on 2021/12/3.
 * for
 */
object ToastUtils {

    private var mToast: Toast? = null

    open fun showToast(msg: CharSequence?) {
        if (mToast != null) {
            mToast!!.cancel()
        }
        mToast = Toast.makeText(MyApp.getInstance(), "", Toast.LENGTH_SHORT)
        mToast?.setText(msg)
        mToast?.show()
    }

    open fun showSnackBar(v: View?, text: String?) {
        Snackbar.make(v!!, text!!, Snackbar.LENGTH_SHORT)
            .setAction("知道了") {
                //nothing to do
            }
            .setActionTextColor(Color.parseColor("#2e90eb"))
            .show()
    }

}