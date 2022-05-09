package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.themovieapp.R
import data.dto.Status
import data.dto.Status.SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel
import presentation.viewmodels.MovieListViewModel

class MovieListFragment: Fragment() {

    private val viewModel: MovieListViewModel by viewModel()
    private lateinit var mText: TextView

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
        mText.setOnClickListener {
            viewModel.getPopularMovies()
        }
    }

    private fun setupObservers() {
        viewModel.movieList.observe(viewLifecycleOwner) {
            when (it.status) {
                SUCCESS -> mText.text = it.data!!.movies.first().name
            }
        }
    }

    private fun findViews(view: View) {
        with(view) {
            mText = findViewById(R.id.text_test)
        }
    }
}