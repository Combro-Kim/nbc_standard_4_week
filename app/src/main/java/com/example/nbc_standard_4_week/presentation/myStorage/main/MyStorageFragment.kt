package com.example.nbc_standard_4_week.presentation.myStorage.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbc_standard_4_week.R
import com.example.nbc_standard_4_week.databinding.FragmentMyStorageBinding
import com.example.nbc_standard_4_week.databinding.FragmentSearchBinding

class MyStorageFragment : Fragment() {
    private var _binding: FragmentMyStorageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_storage, container, false)
    }

}