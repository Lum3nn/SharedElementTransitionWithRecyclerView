package com.example.imgtransitionwithrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.imgtransitionwithrecyclerview.databinding.ItemBinding

class ItemsAdapter(
    private val onItemClicked: ItemAdapterListener
) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val data: List<Item> = listOf(
        Item(R.drawable.ic_1, "Calvin Klein Beauty"),
        Item(R.drawable.ic_2, "Carolina Herrera Good Girl"),
        Item(R.drawable.ic_3, "Dior Dune"),
        Item(R.drawable.ic_4, "Kenzo Kenzo World"),
        Item(R.drawable.ic_5, "Lancome La Vie Est Belle"),
        Item(R.drawable.ic_6, "Marc Jacobs Decadence"),
        Item(R.drawable.ic_7, "Paco Rabanne Lady Million"),
        Item(R.drawable.ic_8, "Roberto Cavalli Deep Desire Red Perfume Bottle"),
        Item(R.drawable.ic_9, "Roberto Cavalli Paradiso"),
        Item(R.drawable.ic_10, "Thierry Mugler Womanity"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = ItemBinding.inflate(layoutInflater, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(data[position], onItemClicked)
    }

    override fun getItemCount(): Int = data.size

    interface ItemAdapterListener {
        fun onItemClicked(imageView: ImageView, item: Item)
    }

    class ItemViewHolder(
        private val binding: ItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, onItemClickListener: ItemAdapterListener) {
            binding.imgDescription.text = item.text
            binding.img.setImageResource(item.id)
            binding.img.transitionName = "img_item_unique_name_${item.id}"

            binding.itemLayout.setOnClickListener { _ ->
                onItemClickListener.onItemClicked(binding.img, item)
            }
        }
    }
}
