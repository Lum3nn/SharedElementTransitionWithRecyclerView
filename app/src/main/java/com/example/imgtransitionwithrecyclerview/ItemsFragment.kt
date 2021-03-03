package com.example.imgtransitionwithrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imgtransitionwithrecyclerview.databinding.ItemsFragmentBinding

class ItemsFragment : Fragment(), ItemsAdapter.ItemAdapterListener {

    private var _binding: ItemsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ItemsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        binding.baseRecycler.setHasFixedSize(true)
        binding.baseRecycler.layoutManager = LinearLayoutManager(view.context)
        binding.baseRecycler.adapter = ItemsAdapter(this)
        binding.baseRecycler.adapter as ItemsAdapter
    }

    override fun onItemClicked(imageView: ImageView, item: Item) {

        val detailImageTransitionName = getString(R.string.detail_img_transition_name)
        val extras = FragmentNavigatorExtras(
            imageView to detailImageTransitionName
        )
        val navAction = ItemsFragmentDirections.actionItemsFragmentToItemDetailsFragment(item.id)
        imageView.findNavController().navigate(navAction, extras)
    }
}
