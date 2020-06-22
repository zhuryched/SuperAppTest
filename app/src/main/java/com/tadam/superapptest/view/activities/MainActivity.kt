package com.tadam.superapptest.view.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.tadam.superapptest.R
import com.tadam.superapptest.databinding.ActivityMainBinding
import com.tadam.superapptest.view.BaseActivity
import com.tadam.superapptest.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun layout(): Int = R.layout.activity_main

    override fun afterCreate(savedInstanceState: Bundle?) {
        vb.bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }
}
