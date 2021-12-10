package com.lzkhy.moble.zkhywater.model.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by lit
 * on 2021/11/29.
 * for
 */

@JsonClass(generateAdapter = true)
class LoginReq ( val username : String?,val password : String?)