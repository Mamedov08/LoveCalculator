package com.example.lovecalculator.ui

import android.content.Context
import android.net.http.SslCertificate.saveState
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.databinding.ItemBoardBinding
import com.example.lovecalculator.model.Board

class BoardAdapter( val navController: NavController, private val startClick: () -> Unit) : Adapter<BoardAdapter.BoardViewHolder>() {

private val list = ArrayList<Board>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
    fun addItem(board: Board) {
        list.add(board)
    }

    inner class BoardViewHolder(private val binding :ItemBoardBinding) : ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.image.setImageResource(board.image)
            binding.title.text = board.title
            binding.desk.text = board.desk

            if (list.lastIndexOf(board) == list.lastIndex) {
                binding.start.visibility = View.VISIBLE
            } else {
                binding.start.visibility = View.INVISIBLE
            }
            binding.start.setOnClickListener {
                 startClick()
                navController.navigateUp()
            }
        }
    }
}