package ru.narod.pricolistov.presentationcomponents.misc

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.ScopeRegistry

fun Fragment.navController(): NavController = Navigation.findNavController(view!!)

class FragmentScope : Scope<Fragment>, LifecycleObserver {
    val map = mutableMapOf<String, ScopeRegistry>()


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {

    }

    override fun getRegistry(context: Fragment): ScopeRegistry{
        return map[context.tag]!!
    }
}

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