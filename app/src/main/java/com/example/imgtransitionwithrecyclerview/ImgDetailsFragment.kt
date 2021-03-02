package com.example.imgtransitionwithrecyclerview

import android.graphics.Color
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.imgtransitionwithrecyclerview.databinding.ImgDetailsFragmentBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough

class ImgDetailsFragment : Fragment() {

    private var _binding: ImgDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: ImgDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ImgDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TRANSITION FOTO

        enterTransition = Fade().setDuration(300.toLong())
        sharedElementEnterTransition =
            TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
                .setDuration(300.toLong());

//        enterTransition = MaterialFadeThrough().setDuration(600.toLong())
//
//        sharedElementEnterTransition = MaterialContainerTransform().apply {
//            duration = 1000.toLong()
//            scrimColor = Color.TRANSPARENT
//            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
//            drawingViewId = R.id.nav_host_fragment
//        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageDetail.setImageResource(args.imgId)
    }
}
