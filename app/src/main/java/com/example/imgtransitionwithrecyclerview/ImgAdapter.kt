package com.example.imgtransitionwithrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imgtransitionwithrecyclerview.databinding.ImgItemBinding

class ImgAdapter(private val onBaseClicked: BaseAdapterListener) :
    RecyclerView.Adapter<ImgAdapter.CategoryViewHolder>() {

    private val data: List<Base> = listOf(
        Base(R.drawable.ic_1, "Calvin Klein Beauty"),
        Base(R.drawable.ic_2, "Carolina Herrera Good Girl"),
        Base(R.drawable.ic_3, "Dior Dune"),
        Base(R.drawable.ic_4, "Kenzo Kenzo World"),
        Base(R.drawable.ic_5, "Lancome La Vie Est Belle"),
        Base(R.drawable.ic_6, "Marc Jacobs Decadence"),
        Base(R.drawable.ic_7, "Paco Rabanne Lady Million"),
        Base(R.drawable.ic_8, "Roberto Cavalli Deep Desire Test"),
        Base(R.drawable.ic_9, "Roberto Cavalli Paradiso"),
        Base(R.drawable.ic_10, "Thierry Mugler Womanity"),
    )

    interface BaseAdapterListener {
        fun onBaseClicked(textView: TextView, imageView: ImageView, base: Base)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = ImgItemBinding.inflate(layoutInflater, parent, false)

        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        holder.bind(data[position], onBaseClicked)
    }

    override fun getItemCount(): Int = data.size


    class CategoryViewHolder(
        private val binding: ImgItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(baseObject: Base, onBaseClickListener: BaseAdapterListener) {
            binding.testClick.text = baseObject.text
            binding.imgItem.setImageResource(baseObject.id)
            binding.imgItem.transitionName = "image${baseObject.id}"

            binding.imgItemLayout.setOnClickListener { v ->
                onBaseClickListener.onBaseClicked(binding.testClick, binding.imgItem, baseObject)
            }
        }
    }
}
