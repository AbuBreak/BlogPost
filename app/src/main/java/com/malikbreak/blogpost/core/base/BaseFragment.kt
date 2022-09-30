package com.malikbreak.blogpost.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.viewbinding.ViewBinding

const val NULL_BINDING = "Binding value cannot be null"

abstract class BaseFragment<FragmentBinding : ViewBinding> : Fragment()  {

    private var _binding: FragmentBinding? = null
    val binding get() = _binding  ?: error(NULL_BINDING)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = getViewBinding()
        return _binding?.root
    }

    

    abstract fun getViewBinding(): FragmentBinding

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}