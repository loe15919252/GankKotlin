package com.xiasuhuei321.gank_kotlin.extension

import android.util.ArrayMap
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Created by CoderFan on 2017/9/14.
 * desc:json转换
 */

/**
 * 对象转换成json字符串
 */
fun <T> toJson(t:T):String = GsonBuilder().create().toJson(t)

fun <T> listToJson(list: Collection<T>):String = GsonBuilder().create().toJson(list)

fun <K,T> mapToJson(map: HashMap<K,T>):String = GsonBuilder().create().toJson(map)


/**
 * json字符串转换指定类型
 */
fun <T> jsonToList(json:String):ArrayList<T>{
    val type = object:TypeToken<ArrayList<T>>(){}
    return GsonBuilder().create().fromJson<ArrayList<T>>(json,type.type)
}

/**
 * 内联函数
 */
inline fun <reified T:Any> json2List(json:String):MutableList<T>{
    val subType = TypeToken.getParameterized(MutableList::class.java,T::class.java)
    return GsonBuilder().create().fromJson(json,subType.type)
}
