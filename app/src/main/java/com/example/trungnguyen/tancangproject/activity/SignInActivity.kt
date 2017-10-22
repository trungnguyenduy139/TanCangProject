package com.example.trungnguyen.tancangproject.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.AppCompatButton
import android.view.View
import com.example.trungnguyen.tancangproject.R
import com.example.trungnguyen.tancangproject.helper.SystemHelper

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    private var etUserName: TextInputEditText? = null
    private var etPassword: TextInputEditText? = null
    private var etContainerType: TextInputEditText? = null

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {
                if (checkForLogIn())
                    startActivity(Intent(this, WorkingListActivity::class.java))
            }
        }
    }

    private fun checkForLogIn(): Boolean {
        val userName = etUserName?.text.toString()
        val password = etPassword?.text.toString()
        val containerType = etContainerType?.text.toString()
        if (userName.isEmpty() || password.isEmpty() || containerType.isEmpty()) {
            SystemHelper.showToastMsg("Vui lòng nhập đầy đủ thông tin")
            return false
        }
        //todo: Check login from server
        return true
    }

    private var btnLogin: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initViews()
    }

    private fun initViews() {
        btnLogin = findViewById(R.id.btn_login)
        btnLogin?.setOnClickListener(this)
        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        etContainerType = findViewById(R.id.etContainerType)
    }
}
