package presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import domain.models.Movie

class MovieListAdapter: PagingDataAdapter<Movie, MovieListAdapter.MovieListViewHolder>(DiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_movie_card, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie?) {
            if (movie == null) {
                return
            }
            val name: TextView = itemView.findViewById(R.id.movie_name)
            name.text = movie.name
        }
    }

    private companion object DiffUtilCallback: DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}