package com.example.nbc_standard_4_week.presentation.myStorage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.nbc_standard_4_week.databinding.FragmentMyStorageBinding
import com.example.nbc_standard_4_week.presentation.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyStorageFragment : Fragment() {
    companion object {
        fun newInstance() = MyStorageFragment()
    }

    private var _binding: FragmentMyStorageBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var myStorageAdapter: MyStorageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() {
        myStorageAdapter = MyStorageAdapter { user ->
            sharedViewModel.setFavoriteList(user)
        }
        binding.rvMyStorage.adapter = myStorageAdapter
    }

    private fun initViewModel() {
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner) { favoriteList ->
            myStorageAdapter.submitList(favoriteList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}