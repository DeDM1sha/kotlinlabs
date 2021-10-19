package ua.cn.stu.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.cn.stu.navigation.contract.navigator
import ua.cn.stu.navigation.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)
        
        binding.buttonOpenLab1.setOnClickListener { onLab1Pressed() }
        binding.buttonOpenLab2.setOnClickListener { onLab2Pressed() }
        binding.buttonOpenLab3.setOnClickListener { onLab3Pressed() }
        binding.aboutButton.setOnClickListener { onAboutPressed() }
        binding.exitButton.setOnClickListener { onExitPressed() }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun onLab1Pressed() {
        navigator().launchLab1Screen()
    }

    private fun onLab2Pressed() {
        navigator().launchLab2Screen()
    }

    private fun onLab3Pressed() {
        navigator().launchLab3Screen()
    }

    private fun onAboutPressed() {
        navigator().showAboutScreen()
    }

    private fun onExitPressed() {
        navigator().goBack()
    }

}

