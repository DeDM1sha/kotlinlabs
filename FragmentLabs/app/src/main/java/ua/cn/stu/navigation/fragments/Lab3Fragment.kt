package ua.cn.stu.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lab3.*
import ua.cn.stu.navigation.R
import ua.cn.stu.navigation.contract.HasCustomTitle
import ua.cn.stu.navigation.databinding.FragmentLab3Binding

fun myReverseFun(str: String): String {
    var reverse = ""

    for (i in str.length - 1 downTo 0) {
        reverse += str[i]
    }

    return reverse

} // самописная функция реверса строки


class Lab3Fragment : Fragment(), HasCustomTitle {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLab3Binding.inflate(inflater, container, false).apply {
        
        buttonInvertStroke.setOnClickListener { onResultButtonPressed() }


    }.root

    private fun onResultButtonPressed() {

        var Stroke = editText_InputStroke.text.toString()

        textView_resultValue.text = myReverseFun(Stroke)

    }


    override fun getTitleRes(): Int = R.string.openLab3
}