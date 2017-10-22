package com.example.trungnguyen.tancangproject.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.view.View
import com.example.trungnguyen.tancangproject.R

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> startActivity(Intent(this, WorkingListActivity::class.java))
        }
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
    }
}
