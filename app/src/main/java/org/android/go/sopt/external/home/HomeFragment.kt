package org.android.go.sopt.external.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentHomeBinding
import org.android.go.sopt.external.SelfBlowableFragment

class HomeFragment : SelfBlowableFragment() {
    val binding: FragmentHomeBinding
        get() = requireNotNull(_binding as FragmentHomeBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val headerAdapter = HomeHeaderAdapter(requireContext())
        val bodyAdapter = HomeBodyAdapter(requireContext())
        bodyAdapter.setList(listOf(
            HomeBodyData(title =  "title", creator =  "daehwan2dadaehwan2dadaehwan2dadaehwan2dadaehwan2dadaehwan2da", image = R.mipmap.image_face,),
            HomeBodyData(title =  "title", creator =  "daehwan2da", image = R.mipmap.image_face,)
        ))
        binding.rvHome.adapter = ConcatAdapter(headerAdapter, bodyAdapter)
    }
}