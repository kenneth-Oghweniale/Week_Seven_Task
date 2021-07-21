package com.kenneth.week_seven_task


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.week_seven_task.databinding.ItemViewBinding

class ItemAdapter(var lists: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemsDataViewHolder>() {

    inner class ItemsDataViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(list: Item){
            binding.textView.text = list.name
            binding.textView2.text = list.price.toString()
            binding.textView1.text = list.id.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsDataViewHolder {
        val binding: ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context))
        return ItemsDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemsDataViewHolder, position: Int) {
        val singleItemsData = lists.get(position)
        holder.bind(singleItemsData)
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}