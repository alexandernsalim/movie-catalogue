package com.alexandernsalim.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alexandernsalim.moviecatalogue.databinding.FragmentMovieBinding
import com.alexandernsalim.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModelFactory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

            val adapter = MovieAdapter()

            fragmentMovieBinding.pbMovie.visibility = View.VISIBLE
            fragmentMovieBinding.rvMovie.visibility = View.GONE
            viewModel.getMovies().observe(viewLifecycleOwner, {
                fragmentMovieBinding.pbMovie.visibility = View.GONE
                fragmentMovieBinding.rvMovie.visibility = View.VISIBLE
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}