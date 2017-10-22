package com.example.trungnguyen.tancangproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trungnguyen.tancangproject.R
import com.example.trungnguyen.tancangproject.adapter.TaskListAdapter
import com.example.trungnguyen.tancangproject.bean.Task

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */
class TaskFragment : Fragment() {

    private var mTaskAdapter: TaskListAdapter? = null

    companion object {
        fun getNewInstance(): TaskFragment {
            return TaskFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.task_fragment, container, false)
        val recyclerViewTask = view?.findViewById<RecyclerView>(R.id.recycler_view_task)
        mTaskAdapter = TaskListAdapter(activity)
        recyclerViewTask?.adapter = mTaskAdapter
        recyclerViewTask?.layoutManager = LinearLayoutManager(activity)
        recyclerViewTask?.setHasFixedSize(true)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val task = Task("", "", 0, 'A', "", "", "")
        val tasks = ArrayList<Task>()
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        tasks.add(task)
        mTaskAdapter?.addNewTask(tasks)
        super.onViewCreated(view, savedInstanceState)
    }
}