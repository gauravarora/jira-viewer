application {
    title = 'JiraViewer2'
    startupGroups = ['jiraViewer2']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "jira-viewer2"
    'jira-viewer2' {
        model      = 'jira.viewer2.JiraViewer2Model'
        view       = 'jira.viewer2.JiraViewer2View'
        controller = 'jira.viewer2.JiraViewer2Controller'
    }

}
