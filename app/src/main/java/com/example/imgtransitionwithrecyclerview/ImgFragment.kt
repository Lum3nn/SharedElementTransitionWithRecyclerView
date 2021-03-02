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
import com.example.imgtransitionwithrecyclerview.databinding.ImgFragmentBinding

class ImgFragment : Fragment(), ImgAdapter.BaseAdapterListener {

    private var _binding: ImgFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ImgFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        binding.baseRecycler.setHasFixedSize(true)
        binding.baseRecycler.layoutManager = LinearLayoutManager(view.context)
        binding.baseRecycler.adapter = ImgAdapter(this)
        binding.baseRecycler.adapter as ImgAdapter
    }

    override fun onBaseClicked(textView: TextView, imageView: ImageView, base: Base) {

        val baseCardImageTransitionName = getString(R.string.base_image_transition_name)
        val extras = FragmentNavigatorExtras(
            imageView to baseCardImageTransitionName
        )
        val navAction = ImgFragmentDirections.actionImgFragmentToImgDetailsFragment(base.id)
        imageView.findNavController().navigate(navAction, extras)
    }

}

