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

import com.lzkhy.moble.zkhywater.model.ApiResult
import com.lzkhy.moble.zkhywater.model.login.LoginReq
import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Query
import javax.inject.Inject

/***
 * retrofit 接口实现类
 */
class HttpClient @Inject constructor(
  private val httpServices: HttpServices
) {

     suspend fun login(
         post: Map<String,String>
  ):  ApiResponse<ApiResult<String>> =
    httpServices.login(post)


//  suspend fun fetchPokemonInfo(
//    name: String
//  ): ApiResponse<PokemonInfo> =
//    pokedexService.fetchPokemonInfo(
//      name = name
//    )

  companion object {
    private const val PAGING_SIZE = 30
  }
}
