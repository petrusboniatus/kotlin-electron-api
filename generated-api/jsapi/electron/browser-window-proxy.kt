package jsapi.electron

class BrowserWindowProxy() {

    private val module: dynamic = js("require('electron').BrowserWindowProxy")

    val instance: dynamic

    init {
        val _constructor = js("require('electron').BrowserWindowProxy")
        instance = js("new _constructor(_)")
    }

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    fun blur(): Unit = 
        instance.blur()

    fun close(): Unit = 
        instance.close()

    fun eval(code: String): Unit = 
        instance.eval(code)

    fun focus(): Unit = 
        instance.focus()

    fun print(): Unit = 
        instance.print()

    fun postMessage(message: String, targetOrigin: String): Unit = 
        instance.postMessage(message, targetOrigin)

    // ~ Builders -------------------------------------------------------------------------------

}

