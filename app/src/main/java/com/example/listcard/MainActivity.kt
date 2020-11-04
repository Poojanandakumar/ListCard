package com.example.listcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listcard.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(){
lateinit var binding:ActivityMainBinding
inner class CardList : RecyclerView.Adapter<CardList.CardViewHolder>() {
    val data = mutableListOf<String>("apple", "mango", "banana", "peach")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val item = inflator.inflate(R.layout.card_list_item, parent, false)
        return CardViewHolder(item)
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.text.text = "${position + 1}. ${data[position]}"

    }

    fun appendItem(s: String) {
        data.add(s)
        notifyItemInserted(data.lastIndex)
    }
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.listcard.adapter = CardList()
    binding.listcard.layoutManager = LinearLayoutManager(this)
    binding.addbutton.setOnClickListener { _ -> addListItem() }
}

    private fun addListItem() {
    val adapter= binding.listcard.adapter as CardList
        adapter.appendItem("Grapes")
    }
}