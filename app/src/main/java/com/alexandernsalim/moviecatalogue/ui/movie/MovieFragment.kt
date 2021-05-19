package com.alexandernsalim.moviecatalogue.ui.movie

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
import com.alexandernsalim.moviecatalogue.databinding.FragmentMovieBinding
import javax.inject.Inject

class MovieFragment : Fragment() {

    @Inject lateinit var movieAdapter: MovieAdapter
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MovieViewModel> { viewModelFactory }

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MovieCatalogueApplication).applicationComponent.homeComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            fragmentMovieBinding.pbMovie.visibility = View.VISIBLE
            fragmentMovieBinding.rvMovie.visibility = View.GONE
            viewModel.getMovies().observe(viewLifecycleOwner, {
                fragmentMovieBinding.pbMovie.visibility = View.GONE
                fragmentMovieBinding.rvMovie.visibility = View.VISIBLE
                movieAdapter.setMovies(it)
                movieAdapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }
}