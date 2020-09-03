package com.shivaprasad.phabelcaretask.ui.home
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaprasad.phabelcaretask.R
import com.shivaprasad.phabelcaretask.data.api.ContactRepository
import com.shivaprasad.phabelcaretask.data.db.AppDataBase
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

    }
}