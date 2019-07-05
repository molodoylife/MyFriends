package ru.narod.pricolistov.presentationcomponents.navigation

import java.util.*

/**
 * <p>
 *     Base class which encapsulates navigation between
 *     components such as Activity or Fragment
 * </p>
 * Created by user on 1/30/18.
 */
open class Navigator<Component : Any>(private var _component: Component? = null) {

    protected val component
        get() = _component

    private val queue: Queue<(Component) -> Unit> = LinkedList()

    val isAttached: Boolean
        get() = _component != null

    fun onAttach(component: Component) {
        if(_component == component) {
            return
        }
        _component = component
        // execute and drop pending events
        val it = queue.iterator()

        while (it.hasNext()) {
            it.next()(component)
            it.remove()
        }

        onAttached(component)
    }

    fun onDetach() {
        val component = _component ?: return

        onDetached(component)
        _component = null
    }

    /**
     * Override this method to provide your own logic
     * which should be executed after corresponding
     * component was attached
     */
    protected open fun onAttached(component: Component) = Unit

    /**
     * Override this method to provide your own logic
     * which should be executed after corresponding
     * component was detached
     */
    protected open fun onDetached(component: Component) = Unit

    /**
     * Runs given action if component is attached or adds
     * it into internal queue to process it later
     */
    protected fun runOrEnqueue(action: (Component) -> Unit) {
        val component = component

        if (component == null) {
            queue += action
        } else {
            action(component)
        }
    }

}