package com.example.nbc_standard_4_week.presentation.search.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nbc_standard_4_week.databinding.FragmentSearchBinding
import com.example.nbc_standard_4_week.presentation.search.adapter.SearchAdapter


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SearchViewModel> {
        SearchViewModelFactory()
    }
    private lateinit var adapter: SearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpViewModel()
        setUpSearchClickListener()

//        viewModel = ViewModelProvider(this, SearchViewModelFactory()).get(SearchViewModel::class.java)


    }

    private fun setUpSearchClickListener() {
        binding.btnSearch.setOnClickListener {
            val searchWord = binding.etSearch.text.toString()
            viewModel.getGitHubUserList(searchWord)
            hideKeyboard()
        }
    }

    private fun setUpRecyclerView() {
        adapter = SearchAdapter()
        binding.searchRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.searchRecyclerView.adapter = adapter
    }

    private fun setUpViewModel() {
        viewModel.getGithubUserList.observe(viewLifecycleOwner) { userList ->
            userList?.let{//null 일 경우 앱 종료됨
                adapter.submitList(userList)
            }
        }
    }

    //검색버튼 클릭 -> 키보드 내림
    private fun hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.btnSearch.windowToken, 0)
    }

    //binding null처리(메모리 누수)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}