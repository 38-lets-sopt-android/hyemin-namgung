package com.example.letssopt.local

import android.content.Context
import androidx.core.content.edit

class UserPreferences(context: Context){
   private val pref =context.getSharedPreferences("user_info", Context.MODE_PRIVATE)

    fun saveUserInfo(email : String, password : String){
        pref.edit {
            putString("email", email)
            putString("password", password)
        }
    } // 회원가입에서 사용

    fun getEmail(): String{
        return pref.getString("email","") ?: ""
    }

    fun getPassword():String{
        return pref.getString("password","") ?: ""
    }

    fun setAutoLogin(isLogin:Boolean) {
        pref.edit{
            putBoolean("is_login", isLogin)
        }
    }

    fun getAutoLogin(): Boolean{
       return pref.getBoolean("is_login",false)
    }

}
