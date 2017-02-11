package jsapi.electron

class ClientRequest(options: dynamic) {

    private val module: dynamic = js("require('electron').ClientRequest")

    val instance: dynamic

    init {
        val _constructor = js("require('electron').ClientRequest")
        val _options = options
        instance = js("new _constructor(_options)")
    }

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    fun setHeader(name: String, value: String): Unit = 
        instance.setHeader(name, value)

    fun getHeader(name: String): String = 
        instance.getHeader(name)

    fun removeHeader(name: String): Unit = 
        instance.removeHeader(name)

    fun write(chunk: dynamic, encoding: String?, callback: (() -> Unit)?): Unit = 
        instance.write(chunk.instance, encoding, callback)

    fun end(chunk: dynamic?, encoding: String?, callback: (() -> Unit)?): Unit = 
        instance.end(chunk?.instance, encoding, callback)

    fun abort(): Unit = 
        instance.abort()

    // ~ Builders -------------------------------------------------------------------------------

    class Session(
    )

}

