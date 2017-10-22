package com.example.trungnguyen.tancangproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import com.example.trungnguyen.tancangproject.R
import com.example.trungnguyen.tancangproject.adapter.ViewPagerAdapter

class WorkingListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_back -> finish()
        }
    }

    private var mTabLayout: TabLayout? = null
    private var mViewPager: ViewPager? = null
    private var mPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_working_list)
        initViews()
        setupAppBar()
    }

    private fun setupAppBar() {
        if (mPagerAdapter == null)
            mPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        mViewPager?.adapter = mPagerAdapter
        mTabLayout?.setupWithViewPager(mViewPager)
    }

    private fun initViews() {
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener(this)
        mTabLayout = findViewById(R.id.tab)
        mViewPager = findViewById(R.id.viewPager)
    }
}
