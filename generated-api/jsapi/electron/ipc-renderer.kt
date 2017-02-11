package jsapi.electron

object ipcRenderer {

    private val module: dynamic = js("require('electron').ipcRenderer")

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    fun on(channel: String, listener: () -> Unit): Unit = 
        module.on(channel, listener)

    fun once(channel: String, listener: () -> Unit): Unit = 
        module.once(channel, listener)

    fun removeListener(channel: String, listener: () -> Unit): Unit = 
        module.removeListener(channel, listener)

    fun removeAllListeners(channel: String?): Unit = 
        module.removeAllListeners(channel)

    fun send(channel: String, args: Array<dynamic>): Unit = 
        module.send(channel, args)

    fun sendSync(channel: String, args: Array<dynamic>): Unit = 
        module.sendSync(channel, args)

    fun sendToHost(channel: String, args: Array<dynamic>): Unit = 
        module.sendToHost(channel, args)

    // ~ Builders -------------------------------------------------------------------------------

}
