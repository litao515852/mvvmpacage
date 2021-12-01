package com.lzkhy.moble.zkhywater.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by lit
 * on 2021/11/30.
 * for
 */

@JsonClass(generateAdapter = true)
class ApiResult<T> {
    var code : Int? = null
    var msg : String? = null
    var data :T? = null
}