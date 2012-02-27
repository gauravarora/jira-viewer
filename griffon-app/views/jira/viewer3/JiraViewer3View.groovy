package jira.viewer3

actions {
	action(id: 'login', name: 'Login', closure: controller.login, mnemonic: 'L', accelerator: shortcut('L'))
	action(id: 'act', name: 'Fetch', closure: controller.act, mnemonic: 'F', accelerator: shortcut('F'))
}
application(title: 'jira-viewer3',
		preferredSize: [6400, 560],
		pack: true,
		//location: [50,50],
		locationByPlatform:true,
		iconImage: imageIcon('/griffon-icon-48x48.png').image,
		iconImages: [
			imageIcon('/griffon-icon-48x48.png').image,
			imageIcon('/griffon-icon-32x32.png').image,
			imageIcon('/griffon-icon-16x16.png').image
		]) {
			panel() {
				boxLayout(axis:BoxLayout.Y_AXIS)
				panel() {
					label('Username: ')
					textField(columns: 10, text: bind('username', target: model, id: 'userbinding'))
					label('Password: ')
					passwordField(columns: 10, text: bind('password', target: model, id: 'passbinding'))
					button(login)
//					label('Token: ')
//					textField(columns: 10, text: bind('loginToken', target: model, id: 'tokenbinding'))
				}
				panel() {
					label('Query: ') 
					textField(columns: 50, text: bind('query', target: model, id: 'querybinding'))
					button(act)
				}
				scrollPane() {
					jxtable(id: 'settingsTable', autoResizeMode: JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS, autoCreateRowSorter: false, rowSorter: null) {
						tableFormat = defaultTableFormat(columnNames: model.columns)
						eventTableModel(source: model.settings, format: tableFormat)
					}
				}

			}
		}