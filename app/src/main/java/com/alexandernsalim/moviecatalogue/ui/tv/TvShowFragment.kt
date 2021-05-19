package com.alexandernsalim.moviecatalogue.ui.tv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alexandernsalim.moviecatalogue.MovieCatalogueApplication
import com.alexandernsalim.moviecatalogue.databinding.FragmentTvShowBinding
import javax.inject.Inject

class TvShowFragment : Fragment() {

    @Inject lateinit var tvShowAdapter: TvShowAdapter
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<TvShowViewModel> { viewModelFactory }

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MovieCatalogueApplication).applicationComponent.homeComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            fragmentTvShowBinding.pbTvShow.visibility = View.VISIBLE
            fragmentTvShowBinding.rvTvShow.visibility = View.GONE
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                fragmentTvShowBinding.pbTvShow.visibility = View.GONE
                fragmentTvShowBinding.rvTvShow.visibility = View.VISIBLE
                tvShowAdapter.setTvShows(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }
}