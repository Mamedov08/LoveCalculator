package com.example.lovecalculator.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHomeBinding
import com.example.lovecalculator.history.HistoryFragment
import com.example.lovecalculator.main.LoveViewModel
import com.example.lovecalculator.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment @Inject constructor(private val prefs : Prefs, private val dataBase: AppDataBase) : Fragment() {




  lateinit var binding :FragmentHomeBinding

  private val viewModel :LoveViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoard()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root

    }


override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initClicker()
}
private fun initClicker() {
    with(binding) {
        historyBtn.setOnClickListener{
            findNavController().navigate(R.id.historyFragment)
        }
        calculateBtn.setOnClickListener {

            viewModel.getLiveLoveModel(firstNameEd.text.toString(),
                secondNameEd.text.toString()
            ).observe(viewLifecycleOwner) {
                dataBase.getDao().insertLove(it)
            }
        }
    }
}

    private fun onBoard() {
        if (!prefs.isShown()) {
            findNavController().navigate(R.id.boardFragment)
        }
    }

}

