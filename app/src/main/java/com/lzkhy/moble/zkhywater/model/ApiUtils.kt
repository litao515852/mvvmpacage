package com.lzkhy.moble.zkhywater.model

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by lit
 * on 2021/12/10.
 * for 用这个来处理token过期
 */
object ApiUtils {
    fun <T>  response(response: ApiResponse<ApiResult<T>>):ApiResponse<ApiResult<T>>{

        // 在这里处理一些异常
        GlobalScope.launch {
            response.suspendOnSuccess {
                if (data.code==5){
                    Timber.d("token 过期")
                }
            }
        }
       return response
    }
}