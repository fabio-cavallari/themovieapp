package presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.themovieapp.R
import presentation.fragments.MovieListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieListFragment())
            .commit()
    }

}