package org.android.go.sopt.external.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.android.go.sopt.databinding.FragmentSearchBinding
import org.android.go.sopt.external.SelfBlowableFragment

class SearchFragment : SelfBlowableFragment() {
    val binding: FragmentSearchBinding
        get() = requireNotNull(_binding as FragmentSearchBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}