package com.example.trungnguyen.tancangproject.bean

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */
class Task internal constructor() {
    private var mShipmentId = ""
    private var mPowerUnit = ""
    private var mTaskId = -1
    private var mStatus = 'X'
    private var mPhoneNumber = ""
    private var mCreateDate = ""
    private var mContent = ""

    constructor(mShipmentId: String, mPowerUnit: String, mTaskId: Int, mStatus: Char, mPhoneNumber: String,
                mCreateDate: String, mContent: String) : this() {
        this.mShipmentId = mShipmentId
        this.mPowerUnit = mPowerUnit
        this.mTaskId = mTaskId
        this.mStatus = mStatus
        this.mPhoneNumber = mPhoneNumber
        this.mCreateDate = mCreateDate
        this.mContent = mContent
    }

    fun getShipmentId() = mShipmentId
    fun getPowerUnit() = mPowerUnit
    fun getTaskId() = mTaskId
    fun getStatus() = mStatus
    fun getPhoneNumber() = mPhoneNumber
    fun getCreateDate() = mCreateDate
    fun getContent() = mContent
}