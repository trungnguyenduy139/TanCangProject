package com.example.trungnguyen.tancangproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trungnguyen.tancangproject.R
import com.example.trungnguyen.tancangproject.bean.Task

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */
class TaskListAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mContext = context
    private val mTaskList = ArrayList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return TaskViewHolder(LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        bindTaskItem(holder as TaskViewHolder, position)
    }

    override fun getItemCount(): Int = mTaskList.size

    fun addNewTask(task: List<Task>) {
        mTaskList.addAll(task)
        this.notifyItemRangeChanged(0, itemCount - 1)
        this.notifyDataSetChanged()
    }

    private fun bindTaskItem(holder: TaskViewHolder, position: Int) {
        val task = mTaskList[position]
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var txtShipmentId: TextView? = null
        var txtPowerUnit: TextView? = null
        var txtTaskId: TextView? = null
        var txtStatus: TextView? = null
        var txtPhone: TextView? = null
        var txtCreateDate: TextView? = null
        var txtContent: TextView? = null

        override fun onClick(view: View?) {
            // todo: Start detail task activity here
        }

        init {
            txtShipmentId = itemView.findViewById(R.id.txt_shipment_id)
            txtPowerUnit = itemView.findViewById(R.id.txt_power_unit)
            txtTaskId = itemView.findViewById(R.id.txt_task_id)
            txtStatus = itemView.findViewById(R.id.txt_status)
            txtPhone = itemView.findViewById(R.id.txt_phone)
            txtCreateDate = itemView.findViewById(R.id.txt_create_date)
            txtContent = itemView.findViewById(R.id.txt_content)
            itemView.setOnClickListener(this)
        }
    }
}