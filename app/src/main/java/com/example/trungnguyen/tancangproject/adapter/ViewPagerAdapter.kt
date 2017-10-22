package com.example.trungnguyen.tancangproject.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.trungnguyen.tancangproject.fragment.TaskFragment
import com.example.trungnguyen.tancangproject.helper.ConstHelper

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */
class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val mFragmentMap = HashMap<String, Fragment>()
    private val mFragmentTitle = ArrayList<String>()

    init {
        mFragmentMap.put(ConstHelper.COMPLETED_TASK, TaskFragment.getNewInstance())
        mFragmentTitle.add(ConstHelper.COMPLETED_TASK)
        mFragmentMap.put(ConstHelper.NEW_TASK, TaskFragment.getNewInstance())
        mFragmentTitle.add(ConstHelper.NEW_TASK)
    }

    override fun getPageTitle(position: Int): CharSequence = mFragmentTitle[position]

    override fun getItem(position: Int): Fragment = mFragmentMap[mFragmentTitle[position]]!!


    override fun getCount(): Int = mFragmentMap.size
}