package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPage2Binding
import com.google.android.material.snackbar.Snackbar


class Page2Fragment : Fragment() {


    private lateinit var binding: FragmentPage2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        binding.button.setOnClickListener{ nav.navigateUp()}


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.page2, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId) {
                    R.id.hello -> {
                        Snackbar.make(binding.root, "Hello World", Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

        }, viewLifecycleOwner)

        return binding.root
    }


}