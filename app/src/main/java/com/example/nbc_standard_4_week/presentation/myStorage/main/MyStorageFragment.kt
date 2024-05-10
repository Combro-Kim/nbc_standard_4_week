package com.example.nbc_standard_4_week.presentation.myStorage.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbc_standard_4_week.databinding.FragmentMyStorageBinding
import com.example.nbc_standard_4_week.presentation.myStorage.SharedViewModel
import com.example.nbc_standard_4_week.presentation.myStorage.adapter.MyStorageAdapter

class MyStorageFragment : Fragment() {
    companion object {
        fun newInstance() = MyStorageFragment()
    }
    private var _binding: FragmentMyStorageBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()

    private val myStorageAdapter: MyStorageAdapter by lazy {
        MyStorageAdapter()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMyStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel(){
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner) { favoriteList ->
            val likedItems = favoriteList.filter { it.isLiked }
            myStorageAdapter.gitHubUserList = likedItems
            with(binding.myStorageRecyclerView){
                layoutManager = LinearLayoutManager(requireContext())
                adapter = myStorageAdapter
            }


        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}