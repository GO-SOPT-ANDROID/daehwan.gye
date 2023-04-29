package org.android.go.sopt.external

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class SelfBlowableFragment(
) : Fragment() {
    protected var _binding: ViewBinding? = null

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}