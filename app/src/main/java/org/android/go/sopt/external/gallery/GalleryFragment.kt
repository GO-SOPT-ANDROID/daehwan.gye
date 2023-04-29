package org.android.go.sopt.external.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.android.go.sopt.databinding.FragmentGalleryBinding
import org.android.go.sopt.external.SelfBlowableFragment

class GalleryFragment : SelfBlowableFragment() {
    private val binding: FragmentGalleryBinding
        get() = requireNotNull(_binding as FragmentGalleryBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}