application {
	title = 'JiraViewer3'
	startupGroups = ['jiraViewer3']

	// Should Griffon exit when no Griffon created frames are showing?
	autoShutdown = true

	// If you want some non-standard application class, apply it here
	//frameClass = 'javax.swing.JFrame'
	mvcGroups {
		// MVC Group for "jira-viewer3"
		'jiraViewer3' {
			model      = 'jira.viewer3.JiraViewer3Model'
			view       = 'jira.viewer3.JiraViewer3View'
			controller = 'jira.viewer3.JiraViewer3Controller'
		}

	}
}