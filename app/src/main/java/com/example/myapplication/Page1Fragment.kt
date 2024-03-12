package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPage1Binding


class Page1Fragment : Fragment() {


    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        binding.button.setOnClickListener{ nav.navigate(R.id.page2Fragment)}

        binding.btnPhone.setOnClickListener {
            val uri = Uri.parse("tel:+60127671159")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        binding.btnSms.setOnClickListener {
            val uri = Uri.parse("sms:+60142340333?body=Hello World")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }

        binding.btnEmail.setOnClickListener {
            val uri = Uri.parse("mailto:liawcv@gmail.com?subject=Demo&body=Hello World")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {
            val uri = Uri.parse("https://www.tarc.edu.my")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.btnMap.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=3.215600,101.728105(TAR UMT)")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        return binding.root
    }


}