package com.example.lovecalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loveModel = arguments?.getSerializable("put") as LoveModel

        with(binding){
            first.text = loveModel.firstName
            second.text = loveModel.secondName
            procent.text = loveModel.persentage
            textView.text = loveModel.result
        }

    }
}
