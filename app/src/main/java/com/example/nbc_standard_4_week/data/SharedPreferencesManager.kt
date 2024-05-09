package com.example.nbc_standard_4_week.data

import android.content.Context
import android.content.SharedPreferences
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPreferencesManager {

    private const val PREF_NAME = "SearchPref" //파일 이름
    private const val SEARCH_WORD = "search_word" //마지막 검색_키워드
    private const val SEARCH_LIST = "search_list" //마지막 검색_결과

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    //검색어 저장
    fun getSearchWord(context: Context, query: String) {
        query.let {
            val editor = getSharedPreferences(context).edit()
            editor.putString(SEARCH_WORD, query)
            editor.apply()
        }
    }

    fun setSearchWord(context: Context): String? {
        return getSharedPreferences(context).getString(SEARCH_WORD, null)
    }

    //검색결과 저장
//    fun getSearchResult(context: Context, searchList: List<GitHubUserEntity>) {
//        searchList.let {
//            val jsonString = Gson().toJson(searchList)
//            val editor = getSharedPreferences(context).edit()
//            editor.putString(SEARCH_LIST, jsonString)
//            editor.apply()
//        }
//    }
//
//    fun setSearchResult(context: Context): List<GitHubUserEntity>? {
//        val jsonString = getSharedPreferences(context).getString(SEARCH_LIST, null)
//        return Gson().fromJson(jsonString, object : TypeToken<List<GitHubUserEntity>>() {}.type)
//    }
}