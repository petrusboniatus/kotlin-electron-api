@file:Suppress("UnsafeCastFromDynamic")
package jsapi.electron

class ClientRequest constructor(val instance: dynamic, z: Unit) {

    constructor(options: dynamic) : this(Unit.let {
        val _constructor = js("require('electron').ClientRequest")
        val _options = options
        js("new _constructor(_options)")
    }, z = Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Boolean specifying whether the request will use HTTP chunked transfer 
     * encoding or not. Defaults to false. The property is readable and writable, 
     * however it can be set only before the first write operation as the HTTP 
     * headers are not yet put on the wire. Trying to set the chunkedEncoding 
     * property after the first write will throw an error.
     *
     * Using chunked encoding is strongly recommended if you need to send a large 
     * request body as data will be streamed in small chunks instead of being 
     * internally buffered inside Electron process memory.
     */
    val chunkedEncoding: Boolean get() = instance.chunkedEncoding


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Adds an extra HTTP header. The header name will issued as it is without 
     * lowercasing. It can be called only before first write. Calling this method 
     * after the first write will throw an error.
     */
    fun setHeader(name: String, value: String): Unit = 
        instance.setHeader(name, value)

    /**
     */
    fun getHeader(name: String): String = 
        instance.getHeader(name)

    /**
     * Removes a previously set extra header name. This method can be called only 
     * before first write. Trying to call it after the first write will throw an 
     * error.
     */
    fun removeHeader(name: String): Unit = 
        instance.removeHeader(name)

    /**
     * callback is essentially a dummy function introduced in the purpose of keeping 
     * similarity with the Node.js API. It is called asynchronously in the next tick 
     * after chunk content have been delivered to the Chromium networking layer. 
     * Contrary to the Node.js implementation, it is not guaranteed that chunk 
     * content have been flushed on the wire before callback is called.
     *
     * Adds a chunk of data to the request body. The first write operation may cause 
     * the request headers to be issued on the wire. After the first write operation, 
     * it is not allowed to add or remove a custom header.
     */
    fun write(chunk: dynamic, encoding: String?, callback: (() -> Unit)?): Unit = 
        instance.write(chunk, encoding, callback)

    /**
     * Sends the last chunk of the request data. Subsequent write or end operations 
     * will not be allowed. The finish event is emitted just after the end operation.
     */
    fun end(chunk: dynamic?, encoding: String?, callback: (() -> Unit)?): Unit = 
        instance.end(chunk, encoding, callback)

    /**
     * Cancels an ongoing HTTP transaction. If the request has already emitted the 
     * close event, the abort operation will have no effect. Otherwise an ongoing 
     * event will emit abort and close events. Additionally, if there is an ongoing 
     * response object,it will emit the aborted event.
     */
    fun abort(): Unit = 
        instance.abort()

    // ~ Companion -----------------------------------------------------------------------------

    companion object { 

        private val module: dynamic = js("require('electron').ClientRequest")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class Session(
    )
}

