package com.example.islami.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.ui.hadethDeatails.HadethDetailsActivity

class HadethFragment : Fragment() {

    lateinit var binding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }

    private fun readHadethFile() {
        val allHadethList: MutableList<Hadeth> = mutableListOf()
        //    بس علي ضمانتنا لو انا مش عايزه اني اتعامل مع ال  contect  علي اساس انه  nullable  نقول  requir context
        // لما يبقول get context  دا بيكون ليه  referance ءعلي ال  context  اما ف حاله ال  activity  بتبقي  start  activity
        val allFileContent = requireContext().assets.open("ahadeth .txt")
            .bufferedReader().use {
                it.readText()

            }
        val seperatedAhadethList = allFileContent.split("#")
        seperatedAhadethList.forEach { hadeth ->
            val hadethLines = hadeth.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            hadethLines.removeAt(0)
            val h = Hadeth(
                title = title,
                contect = hadethLines.joinToString("\n")
            )
            allHadethList.add(h)

        }
        bindingHadethList(allHadethList)
    }

    private fun bindingHadethList(allHadethList: MutableList<Hadeth>) {
        val adapter = HadethListeAdapter(allHadethList)
        adapter.onItemClickListener = HadethListeAdapter.OnItemClickListener { position, hadeth ->
            startHadethDetailsActivity(hadeth);

        }
        binding.chapterRv.adapter = adapter

    }

    private fun startHadethDetailsActivity(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra("hadeth", hadeth)
        startActivity(intent)

    }


}