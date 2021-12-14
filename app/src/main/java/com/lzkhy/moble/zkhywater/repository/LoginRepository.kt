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

package com.lzkhy.moble.zkhywater.repository

import androidx.annotation.WorkerThread
import com.lzkhy.moble.zkhywater.model.ApiUtils
import com.lzkhy.moble.zkhywater.model.login.LoginReq
import com.lzkhy.moble.zkhywater.network.HttpClient
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val httpClient: HttpClient,
) : Repository {

//  @WorkerThread
//  fun login(username: String,
//    password:String,
//    onComplete: () -> Unit,
////    onError: (String?) -> Unit
//  ) =
    /**
     * fetches a [PokemonInfo] from the network and getting [ApiResponse] asynchronously.
     * @see [suspendOnSuccess](https://github.com/skydoves/sandwich#suspendonsuccess-suspendonerror-suspendonexception)
     */
//      flow<String>{
//          val response = httpClient.fetchPokemonList(0)
//          emit("1")
//      }.onCompletion { onComplete() }.flowOn(Dispatchers.IO)

//      response.suspendOnSuccess {
//        pokemonInfoDao.insertPokemonInfo(data)
//        emit(data)
//      }
//        // handles the case when the API request gets an error response.
//        // e.g., internal server error.
//        .onError {
//          /** maps the [ApiResponse.Failure.Error] to the [PokemonErrorResponse] using the mapper. */
//          map(ErrorResponseMapper) { onError("[Code: $code]: $message") }
//        }
//        // handles the case when the API request gets an exception response.
//        // e.g., network connection error.
//        .onException { onError(message) }


    @WorkerThread
    @Synchronized
    suspend fun login(
        username: String,
        password: String,
//    onError: (String?) -> Unit
    ): Boolean {

        var login: Boolean = false

        var map = mutableMapOf<String, String>()
        map.put("username", "13899999999")
        map.put("password", "123456abcd")
//            LoginReq("13899999999","123456abcd")
        val response = httpClient.login(map)

        ApiUtils.response(response).suspendOnSuccess {
            if (data.code == 0) {
                //获取token 并存入
                Timber.d(data.data)
                login = true
            }
        }
        Timber.d(response.toString())

        return login
    }


}
