package com.example.nbc_standard_4_week.presentation.search.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbc_standard_4_week.data.SharedPreferencesManager
import com.example.nbc_standard_4_week.data.repository.SearchRepositoryImpl
import com.example.nbc_standard_4_week.databinding.FragmentSearchBinding
import com.example.nbc_standard_4_week.network.RetrofitClient
import com.example.nbc_standard_4_week.presentation.myStorage.Room.MyDatabase
import com.example.nbc_standard_4_week.presentation.myStorage.Room.SelectedItemRepository
import com.example.nbc_standard_4_week.presentation.search.adapter.SearchAdapter


class SearchFragment : Fragment() {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels {
        SearchViewModelFactory(
            SearchRepositoryImpl(RetrofitClient.searchGitHubUser),
            SelectedItemRepository(MyDatabase.getDatabase(requireContext()).savedItemDao())
        )
    }
    private lateinit var adapter: SearchAdapter

    private val etSearchUser: EditText by lazy {
        binding.etSearch
    }
    private val btnSearch: Button by lazy {
        binding.btnSearch
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initView()
        setUpViewModel()
        setUpSearchClickListener()

    }

    private fun initView() {
        val setSearchWord = SharedPreferencesManager.setSearchWord(requireContext())
        etSearchUser.setText(setSearchWord)


    }

    private fun setUpSearchClickListener() {
        btnSearch.setOnClickListener {
            val searchWord = etSearchUser.text.toString()
            viewModel.getGitHubUserList(searchWord)
            SharedPreferencesManager.getSearchWord(requireContext(), searchWord) //검색어 저장
            hideKeyboard()
        }
    }

    private fun initRecyclerView() {
        adapter = SearchAdapter()
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter
        setUpItemClickEvent()
    }

    private fun setUpItemClickEvent() {
        adapter.itemClick = object : SearchAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = adapter.currentList[position]
                //todo 보관함 추가
                viewModel.saveSelectedItem(selectedItem)
                //todo 좋아요 데이터 변경 알림
                selectedItem.isLiked = !selectedItem.isLiked
            }
        }
    }

    private fun setUpViewModel() {
        viewModel.getGithubUserList.observe(viewLifecycleOwner) { userList ->
            userList?.let {
                adapter.submitList(userList)
            }
        }
    }

    //검색버튼 클릭 -> 키보드 내림
    private fun hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.btnSearch.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}