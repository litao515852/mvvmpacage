/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lzkhy.moble.zkhywater.network

import com.lzkhy.moble.zkhywater.sp.SPUtils
import okhttp3.*
import timber.log.Timber
import java.nio.charset.Charset

import okio.*


/***
 * 网络请求类 的 拦截器
 */
class HttpRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // 传入token
        request.newBuilder()
            .addHeader("authorization", SPUtils.get(SPUtils.token,"") as String)
            .addHeader("platform","android")
        printRequestMessage(request)
        val response = chain.proceed(request)
        printResponseMessage(response)
        return response
    }


    /**
     * 打印请求消息
     *
     * @param request 请求的对象
     */
    private fun printRequestMessage(request: Request?) {
        if (request == null) {
            return
        }
        Timber.d("Url   : " + request.url.toString())
        Timber.d("Method: " + request.method)
        Timber.d("Heads : " + request.headers)
        val requestBody: RequestBody = request.body ?: return
        try {
            val bufferedSink = Buffer()
            requestBody.writeTo(bufferedSink)
            var charset = requestBody.contentType()!!.charset()
            charset = charset ?: Charset.forName("utf-8")

            Timber.d("Params: " + bufferedSink.readString(charset!!))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 打印返回消息
     *
     * @param response 返回的对象
     */
    private fun printResponseMessage(response: Response?) {
        if (response == null || !response.isSuccessful) {
            return
        }
        val responseBody = response.body
        val contentLength = responseBody!!.contentLength()
        val source = responseBody.source()
        try {
            source.request(Long.MAX_VALUE) // Buffer the entire body.
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val buffer: Buffer = source.buffer
        var charset: Charset = Charset.forName("UTF-8")
        val contentType: MediaType? = responseBody.contentType()
        if (contentType != null) {
            charset = contentType.charset()!!
        }
        if (contentLength != 0L) {
            val result: String = buffer.clone().readString(charset)
            Timber.d("Response: $result")
        }
    }
}
