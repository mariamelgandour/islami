package com.example.islami.ui.hadethDeatails

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.home.hadeth.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    var hadeth: Hadeth? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readExters()
        initViews()


    }

    private fun initViews() {
        title = null
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.hadethTitle.text = hadeth?.title
        binding.content.hadethContent.text = hadeth?.contect


    }

    private fun readExters() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(EXTRA_HADITH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(EXTRA_HADITH) as Hadeth?
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_HADITH = "hadeth"
    }


}