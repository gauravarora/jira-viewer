root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'GlazedlistsGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'TangoiconsGriffonAddon'.addon=true

root.'JxlayerGriffonAddon'.addon=true

root.'JbusyComponentGriffonAddon'.addon=true
