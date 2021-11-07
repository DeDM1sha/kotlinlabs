package ua.cn.stu.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lab1.*
import ua.cn.stu.navigation.R
import ua.cn.stu.navigation.contract.HasCustomTitle
import ua.cn.stu.navigation.databinding.FragmentLab5Binding
import kotlinx.android.synthetic.main.fragment_lab5.*

class Lab5Fragment : Fragment(), HasCustomTitle {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLab5Binding.inflate(inflater, container, false).apply {
       // buttonResultButton.setOnClickListener { onResultButtonPressed() }
        //radioButtonFirst.setOnClickListener {radioButtonFirst.isPressed()}

        buttonCalculate.setOnClickListener{onButtonCalculatePressed() }

    }.root

    private fun onButtonCalculatePressed() {

        var Str_FinResult = editTextNumber_FinResult.text.toString()
        var FinResult = 0.0;

            if (Str_FinResult.length > 0)
                FinResult = Str_FinResult.toDouble()

        var Str_FinCost = editTextNumber_FinCost.text.toString()
        var FinCost = 0.0;

            if (Str_FinCost.length > 0)
                FinCost = Str_FinCost.toDouble()

        var Discount = 2.0;

            if (radioButton_first.isChecked)
                Discount = 35.0;

            else if (radioButton_second.isChecked)
                Discount = 17.0;

            else if (radioButton_third.isChecked)
                Discount = 64.0;


        val Finance = (FinResult - FinCost) * (1.0 - (Discount / 100.0))

        textView_resultCalculate.text = Finance.toString()

    }


    override fun getTitleRes(): Int = R.string.openLab5
}