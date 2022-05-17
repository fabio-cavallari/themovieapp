package presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R

class MovieListLoadStateAdapter(
    private val retry: () -> Unit
): LoadStateAdapter<MovieListLoadStateAdapter.MovieListLoadStateAdapterViewHolder>() {
    inner class MovieListLoadStateAdapterViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        fun bind(loadState: LoadState) {
            val loadingView: ProgressBar = itemView.findViewById(R.id.loading_view)
            val errorView: View = itemView.findViewById(R.id.error_view)
            loadingView.isVisible = loadState is LoadState.Loading
            errorView.isVisible = loadState is LoadState.Error
            errorView.setOnClickListener { retry() }
        }
    }

    override fun onBindViewHolder(
        holder: MovieListLoadStateAdapterViewHolder,
        loadState: LoadState,
    ) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): MovieListLoadStateAdapterViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_movie_load_state, parent, false)
        return MovieListLoadStateAdapterViewHolder(view)
    }
}