package com.example.islami.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    var chapterPosition: Int = -1;
    lateinit var chapterTitle: String

    lateinit var versesRecycler: RecyclerView;
    lateinit var binding: ActivityChapterDetailsBinding;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //  setContentView(R.layout.activity_chapter_details)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding
        initParameters()
        initViews()
        readChapter()

    }

    private fun readChapter() {
        val allFileContent = assets.open("${chapterPosition + 1}.txt")
            .bufferedReader().use {
                it.readText()

            }
        val versesList = allFileContent.split("\n")
        bindVersestorecyclerView(versesList);
    }

    private fun bindVersestorecyclerView(versesList: List<String>) {
        val versesAdapter = VersesAdapter(versesList)
        versesRecycler.adapter = versesAdapter

    }

    private fun initViews() {
        // to show back bottom

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = null

        binding.chapterTitle.setText(chapterTitle)
        versesRecycler = findViewById(R.id.verses_recycler)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        //or  ممكن اشي ال  on back pressed
        // واحط مكانها finish()
        return true
    }

    private fun initParameters() {
        chapterPosition = intent.getIntExtra(EXTERA_POSITION, -1)
        chapterTitle = intent.getStringExtra(EXTERA_TITLE) ?: ""
    }

    companion object {
        // بيعبر عنها ف الجافا ب  static  اما فال  kotlin  اسمه كدا
        const val EXTERA_TITLE = "title"
        const val EXTERA_POSITION = "position"

    }
}