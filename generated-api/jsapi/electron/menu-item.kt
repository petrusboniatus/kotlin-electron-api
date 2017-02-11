package jsapi.electron

class MenuItem(options: Options.() -> Unit) {

    private val module: dynamic = js("require('electron').MenuItem")

    val instance: dynamic

    init {
        val _constructor = js("require('electron').MenuItem")
        val _options = options.let { Options().apply(it) }
        instance = js("new _constructor(_options)")
    }

    fun onEvent(event: String, callback: () -> Unit) = 
        module.on(event, callback)

    // ~ Builders -------------------------------------------------------------------------------

    class Options(
        var click: ((menuItem: MenuItem, browserWindow: BrowserWindow, event: dynamic) -> Unit)? = null, 
        var role: String? = null, 
        var type: String? = null, 
        var label: String? = null, 
        var sublabel: String? = null, 
        var accelerator: dynamic? = null, 
        var icon: dynamic? = null, 
        var enabled: Boolean? = null, 
        var visible: Boolean? = null, 
        var checked: Boolean? = null, 
        var submenu: dynamic? = null, 
        var id: String? = null, 
        var position: String? = null
    )

}

