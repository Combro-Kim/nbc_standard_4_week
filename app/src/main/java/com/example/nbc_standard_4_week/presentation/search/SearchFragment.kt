package com.example.nbc_standard_4_week.presentation.search

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.nbc_standard_4_week.data.sharedpreferences.SharedPreferencesManager
import com.example.nbc_standard_4_week.databinding.FragmentSearchBinding
import com.example.nbc_standard_4_week.presentation.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {
    companion object {
        fun newInstance() = SearchFragment()
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    //activityViewModels
    //activityViewModels() 사용 시 Activity의 라이프사이클에 의해 생존주기 결정되며 액티비티내에서 같은 데이터 공유

    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(
            onClick = { user -> sharedViewModel.setFavoriteList(user) },
            isFavorite = { userId -> sharedViewModel.isFavorite(userId) }
        )
    }

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
        initView()
        initViewModel()
        setUpSearchClickListener()
    }

    private fun initView() {
        //저장된 검색어 보이기
        val setSearchWord = SharedPreferencesManager.setSearchWord(requireContext())
        etSearchUser.setText(setSearchWord)
    }

    private fun initViewModel() {
        viewModel.getGithubUserList.observe(viewLifecycleOwner) { userList ->
            searchAdapter.submitList(userList)
            binding.searchRecyclerView.adapter = searchAdapter
        }
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner) {
            searchAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpSearchClickListener() {
        btnSearch.setOnClickListener {
            val searchWord = etSearchUser.text.toString().replace(" ","") //검색어
            viewModel.searchGitHubUserList(searchWord) //
            SharedPreferencesManager.getSearchWord(requireContext(), searchWord) //검색어 저장
            hideKeyboard()
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