package ua.cn.stu.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lab1.*
import ua.cn.stu.navigation.R
import ua.cn.stu.navigation.contract.HasCustomTitle
import ua.cn.stu.navigation.databinding.FragmentLab1Binding

class Lab1Fragment : Fragment(), HasCustomTitle {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLab1Binding.inflate(inflater, container, false).apply {

        buttonResultButton.setOnClickListener { onResultButtonPressed() }

    }.root

    private fun onResultButtonPressed() {

        var StrAge = editTextNumber_editAge.text.toString()
        var Age = 1

        if (StrAge.length > 0)
            Age = StrAge.toInt()

        if (Age > -1 && Age <= 20)
            textView_textResult.text = "Вы слишком молоды!"
        else if (Age == 30 || Age == 40 || Age == 50 || Age == 60)
            textView_textResult.text = "Поздравляем с повышением!"
        else if (Age == 65)
            textView_textResult.text = "Преподносим вам золотые часы!"
        else if (Age > 65)
            textView_textResult.text = "Вы слишком стары!"
        else
            textView_textResult.text = "Продолжайте накапливать опыт!"

    }


    override fun getTitleRes(): Int = R.string.openLab1
}