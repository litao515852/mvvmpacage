package com.lzkhy.moble.zkhywater.sp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.lzkhy.moble.zkhywater.MyApp
import java.lang.IllegalArgumentException
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Created by lit
 * on 2021/12/16.
 * for
 */
object SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    const val FILE_NAME = "share_data"

    val token="token"

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    fun put(key: String?, Object: Any) {
        val sp: SharedPreferences = MyApp.getInstance()!!.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sp.edit()
        when (Object) {
            is String -> {
                editor.putString(key, Object)
            }
            is Int -> {
                editor.putInt(key, Object)
            }
            is Boolean -> {
                editor.putBoolean(key, Object)
            }
            is Float -> {
                editor.putFloat(key, Object)
            }
            is Long -> {
                editor.putLong(key, Object)
            }
            else -> {
                editor.putString(key, Object.toString())
            }
        }
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    operator fun get(key: String?, defaultObject: Any?): Any? {
        val sp: SharedPreferences = MyApp.getInstance()!!.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        when (defaultObject) {
            is String -> {
                return sp.getString(key, defaultObject as String?)
            }
            is Int -> {
                return sp.getInt(key, (defaultObject as Int?)!!)
            }
            is Boolean -> {
                return sp.getBoolean(key, (defaultObject as Boolean?)!!)
            }
            is Float -> {
                return sp.getFloat(key, (defaultObject as Float?)!!)
            }
            is Long -> {
                return sp.getLong(key, (defaultObject as Long?)!!)
            }
            else -> return null
        }
    }

    /**
     * 移除某个key值已经对应的值
     * @param context
     * @param key
     */
    fun remove(key: String?) {
        val sp: SharedPreferences = MyApp.getInstance()!!.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sp.edit()
        editor.remove(key)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 清除所有数据
     */
    fun clear() {
        val sp: SharedPreferences = MyApp.getInstance()!!.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sp.edit()
        editor.clear()
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private object SharedPreferencesCompat {
        private val sApplyMethod: Method? = findApplyMethod()

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        private fun findApplyMethod(): Method? {
            try {
                val clz: Class<*> = SharedPreferences.Editor::class.java
                return clz.getMethod("apply")
            } catch (e: NoSuchMethodException) {
            }
            return null
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        fun apply(editor: SharedPreferences.Editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor)
                    return
                }
            } catch (e: IllegalArgumentException) {
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            }
            editor.commit()
        }
    }
}