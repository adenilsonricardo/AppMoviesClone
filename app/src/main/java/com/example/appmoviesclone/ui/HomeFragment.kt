package com.example.appmoviesclone.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmoviesclone.MainActivity
import com.example.appmoviesclone.R
import com.example.appmoviesclone.databinding.HomeFragmentBinding
import com.example.appmoviesclone.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> {viewModelFactory}
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
    }
    private lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        attachObsevers()
        return binding.root
    }
    private fun attachObservers() {
        listsOfMoviesObserver()
    }
    private fun listsOfMoviesObserver() {
        viewModel.listsOfMovies?.observe(viewLifecycleOwner, Observer { lists ->
            lists?.let {
                binding.rvListsOfMovies.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvListsOfMovies.adapter = ListsOfMoviesAdapter(requireContext(), lists)
            }
        })
    }
}
