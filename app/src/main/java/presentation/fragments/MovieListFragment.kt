package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import data.dto.Status.ERROR
import data.dto.Status.LOADING
import data.dto.Status.SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel
import presentation.adapters.MovieListAdapter
import presentation.viewmodels.MovieListViewModel

class MovieListFragment: Fragment() {

    private val viewModel: MovieListViewModel by viewModel()
    private lateinit var loadingView: TextView
    private lateinit var errorView: TextView
    private lateinit var getButton: TextView
    private lateinit var movieList: RecyclerView
    private val movieListAdapter: MovieListAdapter by lazy { MovieListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        findViews(view)
        setupObservers()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getButton.setOnClickListener {
            viewModel.getPopularMovies()
        }
        movieList.adapter = movieListAdapter
        movieList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setupObservers() {
        viewModel.movieList.observe(viewLifecycleOwner) {
            when (it.status) {
                SUCCESS -> {
                    getButton.visibility = View.GONE
                    errorView.visibility = View.GONE
                    loadingView.visibility = View.GONE
                    movieList.visibility = View.VISIBLE
                    movieListAdapter.submitList(it.data!!.movies)
                }
                LOADING -> {
                    getButton.visibility = View.GONE
                    errorView.visibility = View.GONE
                    loadingView.visibility = View.VISIBLE
                    movieList.visibility = View.GONE
                }
                ERROR -> {
                    getButton.visibility = View.GONE
                    errorView.visibility = View.VISIBLE
                    loadingView.visibility = View.GONE
                    movieList.visibility = View.GONE
                }
            }
        }
    }

    private fun findViews(view: View) {
        with(view) {
            getButton = findViewById(R.id.get_button)
            loadingView = findViewById(R.id.loading_view)
            errorView = findViewById(R.id.error_view)
            movieList = findViewById(R.id.movie_list)
        }
    }
}