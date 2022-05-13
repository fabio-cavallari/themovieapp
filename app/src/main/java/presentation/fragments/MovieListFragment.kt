package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import kotlinx.coroutines.launch
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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        getButton.setOnClickListener {
//            viewModel.getPopularMovies(1)
//        }
        movieList.adapter = movieListAdapter
        movieList.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        movieList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getPopularMovies().observe(viewLifecycleOwner) {
                movieListAdapter.submitData(lifecycle, it)
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
        getButton.visibility = View.GONE
        errorView.visibility = View.GONE
        loadingView.visibility = View.GONE
        movieList.visibility = View.VISIBLE
    }

    private fun setupLoadingState() {
        getButton.visibility = View.GONE
        errorView.visibility = View.GONE
        loadingView.visibility = View.VISIBLE
        movieList.visibility = View.GONE
    }

    private fun setupErrorState() {
        getButton.visibility = View.GONE
        errorView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
        movieList.visibility = View.GONE
    }
}