log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

<<<<<<< HEAD
    error  'org.codehaus.griffon',
			'org.apache'
=======
    error  'org.codehaus.griffon'
>>>>>>> afbe12010b23aa2e060f86c199dbb550deb0da55

    info   'griffon.util',
           'griffon.core',
           'griffon.swing',
           'griffon.app'
}

