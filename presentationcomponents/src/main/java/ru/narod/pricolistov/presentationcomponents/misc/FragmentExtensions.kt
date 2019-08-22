package ru.narod.pricolistov.presentationcomponents.misc


import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.ScopeRegistry
import org.kodein.di.bindings.StandardScopeRegistry

val Fragment.fragmentScope: FragmentScope
    get() {
        lifecycle.addObserver(FragmentScope)
        return FragmentScope
    }


object FragmentScope : Scope<Fragment>, LifecycleObserver {
    val map = mutableMapOf<Int, ScopeRegistry>()

    override fun getRegistry(context: Fragment): ScopeRegistry =
        map.getOrPut(context.id, ::StandardScopeRegistry)


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun handleDestroy(o: LifecycleOwner) {
        handleDestroy(o as Fragment)
    }

    private fun handleDestroy(fragment: Fragment) {
        if (fragment.wontBeReCreated) {
            map.remove(fragment.id)?.clear()
        }
    }
}

// We don't keep fragment injections when:
// * activity is finishing
// * activity is being destroyed because of non-config changes
// * activity is being destroyed because of config changes,
private val Fragment.wontBeReCreated: Boolean
    get() = requireActivity().willNotBeReCreated || requireActivity().isDestroyingBecauseOfConfigChanges

private val Activity.willNotBeReCreated: Boolean
    get() = isFinishing || !isDestroyingBecauseOfConfigChanges

private val Activity.isDestroyingBecauseOfConfigChanges: Boolean
    get() = changingConfigurations != 0

