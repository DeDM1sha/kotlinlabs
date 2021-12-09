package ua.cn.stu.navigation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import ua.cn.stu.navigation.R
import ua.cn.stu.navigation.contract.HasCustomTitle
import ua.cn.stu.navigation.databinding.FragmentLab4Binding
import kotlinx.android.synthetic.main.fragment_lab4.*

class Lab4Fragment : Fragment(), HasCustomTitle {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("index", Index)
        outState.putInt("counter", Counter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

    }

    val answerRight = "Right! :)"
    val answerWrong = "Wrong!!! :("

    val Questions = arrayOf<String>("1) Летом холоднее чем зимой",
                                    "2) 1кг гвоздей тяжелее 1кг опилок",
                                    "3) SibGU the best"); // массив вопросов

    var Index = 0; // индекс вопроса
    var Counter = 0; // счетчик правильных ответов

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLab4Binding.inflate(inflater, container, false).apply {

        buttonTrue.setOnClickListener{onButtonTruePressed() }
        buttonFalse.setOnClickListener{onButtonFalsePressed() }
        buttonNext.setOnClickListener{onButtonNextPressed() }
        buttonRepeat.setOnClickListener{onButtonRepeatPressed() }

        buttonNext.visibility = View.GONE

        if (savedInstanceState != null) {
            Index = savedInstanceState.getInt("index")
            Counter = savedInstanceState.getInt("counter")
        }
        textViewQuestion.text = Questions[Index];


    }.root

    private fun closeButtons () {

        button_True.visibility = View.GONE;
        button_False.visibility = View.GONE;
        button_Next.visibility = View.VISIBLE;
        Index++;

    }

    private fun openButtons () {

            if (Index <= 2)  {

                button_True.visibility = View.VISIBLE;
                button_False.visibility = View.VISIBLE;
                button_Next.visibility = View.GONE;
                textView_Question.text = Questions[Index];

            }

            else {

                button_Next.visibility = View.GONE;
                textView_Question.text = "Вопросы закончились!";
                Toast.makeText(activity, "Counter: " + Counter, Toast.LENGTH_LONG).show()
                Index = 0;
                Counter = 0;

            }

    }

    private fun checkAnswers (Flag: Boolean) : String{

        if (((Index == 0 || Index == 1) && Flag == false) || (Index == 2 && Flag == true)) {

            Counter++;
            return answerRight;

        }

        return answerWrong;

    }

    private fun onButtonTruePressed() {

        textView_Question.text = checkAnswers(true);
        Toast.makeText(activity, (Index + 1).toString() + ") " + textView_Question.text, Toast.LENGTH_LONG).show()
        closeButtons();

    }

    private fun onButtonFalsePressed() {

        textView_Question.text = checkAnswers(false);
        Toast.makeText(activity, (Index + 1).toString() + ") " + textView_Question.text, Toast.LENGTH_LONG).show()
        closeButtons();

    }

    private fun onButtonNextPressed() {

        openButtons();

    }

    private fun onButtonRepeatPressed() {

        Index = 0;
        Counter = 0;
        openButtons();

    }

    override fun getTitleRes(): Int = R.string.openLab4
}