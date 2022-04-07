package com.home.newsapi.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.home.newsapi.databinding.FragmentNewsBinding
import com.home.newsapi.ui.adapters.NewsAdapter
import com.home.newsapi.ui.news.viewmodel.NewsViewModel
import com.home.newsapi.utils.Resource

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsAdapter = NewsAdapter()

        binding.recyclerViewNews.apply {
            adapter = newsAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.topNews.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    hideProgressBar()
                    resource.data?.let {
                        newsAdapter.submitList(resource.data)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

                is Resource.Error -> {
                    showProgressBar()
                    resource.message?.let {
                        showToast(it)
                    }
                }
            }
        }
    }

    private fun showToast(it: String) {
        Toast
            .makeText(context, it, Toast.LENGTH_LONG)
            .show()
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
