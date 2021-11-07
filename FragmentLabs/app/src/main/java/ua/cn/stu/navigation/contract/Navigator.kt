package ua.cn.stu.navigation.contract

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun launchLab1Screen()

    fun launchLab2Screen()

    fun launchLab3Screen()

    fun launchLab4Screen()

    fun launchLab5Screen()

    fun showAboutScreen()

    fun goBack()

    fun goToMenu()

}