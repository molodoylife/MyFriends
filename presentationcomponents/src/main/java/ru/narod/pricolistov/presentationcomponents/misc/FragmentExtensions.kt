package ru.narod.pricolistov.presentationcomponents.misc

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

fun Fragment.navController(): NavController = Navigation.findNavController(view!!)

//fun Fragment.navController(@IdRes controllerRes: Int): NavController {
//    return Navigation.findNavController(activity as Activity, controllerRes)
//}

//fun Fragment.hideSoftKeyboard() {
//    activity?.hideSoftKeyboard()
//}
//
//fun Fragment.showSoftKeyboard() {
//    activity?.showSoftKeyboard()
//}

//@Suppress("UNCHECKED_CAST")
//fun <T : Fragment> Fragment.findFragment(@IdRes id: Int): T {
//    return childFragmentManager.findFragmentById(id) as T
//}
//
//fun Fragment.setInputModeAdjustPan() = requireActivity().window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
//
//fun Fragment.setInputModeAdjustResize() = requireActivity().window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)