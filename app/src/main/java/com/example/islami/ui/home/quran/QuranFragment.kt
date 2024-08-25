package com.example.islami.ui.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.chapterDetails.ChapterDetailsActivity

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    var chapterTitles = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)


        return binding.root
    }

    lateinit var chapterRecycler: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }

    val chapterAdapter = ChapterRecyclerAdapter(chapterTitles)
    private fun initview(view: View) {
        chapterRecycler = view.findViewById(R.id.chapter_rv)
        chapterAdapter.onItemClickListener =
            ChapterRecyclerAdapter.OnItemClickListener { title, position ->
                //start chapterDetails activity
                startChapterDetailsActivity(position, title);
            }
        chapterRecycler.adapter = chapterAdapter

    }

    private fun startChapterDetailsActivity(position: Int, title: String) {
        // هنا هو اعترض لان انا جوا  fragment  مش جوا activity  ف بالتالي هو محتاج  context  لل activity  اللي ال fragment  جوا فبدل مانعمل  this  عتكون  activity or context
        val intent = Intent(context, ChapterDetailsActivity::class.java)
        // كدا ممكن يديني ايرور لان كاتباه ب ايدي ممكن نعمله  constant
        intent.putExtra(ChapterDetailsActivity.EXTERA_POSITION, position)
        intent.putExtra(ChapterDetailsActivity.EXTERA_TITLE, title)
        startActivity(intent)

    }
}