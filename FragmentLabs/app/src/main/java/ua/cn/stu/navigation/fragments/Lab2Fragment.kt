package ua.cn.stu.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lab2.*
import ua.cn.stu.navigation.R
import ua.cn.stu.navigation.contract.HasCustomTitle
import ua.cn.stu.navigation.databinding.FragmentLab2Binding

class Lab2Fragment : Fragment(), HasCustomTitle {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLab2Binding.inflate(inflater, container, false).apply {

        buttonCalculate.setOnClickListener { onResultButtonPressed() }

    }.root

    private fun onResultButtonPressed() {

        var StrNum = editTextNumber_InputNum.text.toString()
        var Num = 1
        var a: Double = 1.0
        var diff: Double = 2.0
        var coef: Double = 1.0 / diff

        if (StrNum.length > 0)
            Num = StrNum.toInt()

        if (Num > 7)
            textView_resultValue.text = "Error"
        else {

            while (Num > a) {

                a += coef
                diff += 1.0
                coef = 1.0 / diff

            }
            textView_resultValue.text = a.toString()


        }

    }


    override fun getTitleRes(): Int = R.string.openLab2
}