package com.alexandernsalim.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alexandernsalim.moviecatalogue.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShows = viewModel.getTvShows()

            val adapter = TvShowAdapter()
            adapter.setTvShows(tvShows)

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}