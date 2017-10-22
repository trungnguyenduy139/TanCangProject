package com.example.trungnguyen.tancangproject.helper

import android.widget.Toast
import com.example.trungnguyen.tancangproject.base.App

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */
object SystemHelper {
    fun showToastMsg(msg: String) {
        Toast.makeText(App.instance?.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}