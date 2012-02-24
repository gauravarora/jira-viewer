application {
<<<<<<< HEAD
    title = 'JiraViewer3'
    startupGroups = ['jiraViewer3']
=======
    title = 'JiraViewer2'
    startupGroups = ['jiraViewer2']
>>>>>>> afbe12010b23aa2e060f86c199dbb550deb0da55

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
<<<<<<< HEAD
    // MVC Group for "jira-viewer3"
    'jiraViewer3' {
        model      = 'jira.viewer3.JiraViewer3Model'
        view       = 'jira.viewer3.JiraViewer3View'
        controller = 'jira.viewer3.JiraViewer3Controller'
=======
    // MVC Group for "jira-viewer2"
    'jira-viewer2' {
        model      = 'jira.viewer2.JiraViewer2Model'
        view       = 'jira.viewer2.JiraViewer2View'
        controller = 'jira.viewer2.JiraViewer2Controller'
>>>>>>> afbe12010b23aa2e060f86c199dbb550deb0da55
    }

}
