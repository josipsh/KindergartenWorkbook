package hr.kindergartenworkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.kindergartenworkbook.data.Repository
import hr.kindergartenworkbook.databinding.ActivityMainBinding
import hr.kindergartenworkbook.view.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.navHostView, LoginFragment(Repository()))
            .commit()
    }
}