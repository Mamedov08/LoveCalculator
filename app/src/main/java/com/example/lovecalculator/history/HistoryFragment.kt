package com.example.lovecalculator.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.room.AppDataBase
import javax.inject.Inject

class HistoryFragment @Inject constructor(private val dataBase: AppDataBase) : Fragment() {
    lateinit var bindind: FragmentHistoryBinding
    lateinit var adapter: HistoryAdapter
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        bindind = FragmentHistoryBinding.inflate(inflater, container, false)
        return bindind.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerHistory()
    }
    private fun observerHistory() {
        dataBase.getDao().getAll().observe(viewLifecycleOwner, Observer {
            adapter = HistoryAdapter(it)
            bindind.recyclerView.adapter = adapter
        })
    }
}


