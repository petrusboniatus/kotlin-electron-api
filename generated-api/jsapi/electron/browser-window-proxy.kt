@file:Suppress("UnsafeCastFromDynamic")
package jsapi.electron

class BrowserWindowProxy constructor(val instance: dynamic, z: Unit) {

    constructor() : this(Unit.let {
        val _constructor = js("require('electron').BrowserWindowProxy")
        js("new _constructor()")
    }, z = Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Boolean that is set to true after the child window gets closed.
     */
    val closed: Boolean get() = instance.closed


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Removes focus from the child window.
     */
    fun blur(): Unit = 
        instance.blur()

    /**
     * Forcefully closes the child window without calling its unload event.
     */
    fun close(): Unit = 
        instance.close()

    /**
     * Evaluates the code in the child window.
     */
    fun eval(code: String): Unit = 
        instance.eval(code)

    /**
     * Focuses the child window (brings the window to front).
     */
    fun focus(): Unit = 
        instance.focus()

    /**
     * Invokes the print dialog on the child window.
     */
    fun print(): Unit = 
        instance.print()

    /**
     * Sends a message to the child window with the specified origin or * for no 
     * origin preference.
     *
     * In addition to these methods, the child window implements window.opener object 
     * with no properties and a single method.
     */
    fun postMessage(message: String, targetOrigin: String): Unit = 
        instance.postMessage(message, targetOrigin)

    // ~ Companion -----------------------------------------------------------------------------

    companion object { 

        private val module: dynamic = js("require('electron').BrowserWindowProxy")

    }

    // ~ Builders ------------------------------------------------------------------------------
}

