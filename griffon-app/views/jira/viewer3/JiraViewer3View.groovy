package jira.viewer3

actions {
	action(id: 'act', name: 'Open HTML file..', closure: controller.act, mnemonic: 'O', accelerator: shortcut('O'))
}
application(title: 'jira-viewer3',
		preferredSize: [320, 240],
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
				button(act)
				scrollPane() {
					jxtable(id: 'settingsTable', autoResizeMode: JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS, autoCreateRowSorter: false, rowSorter: null, preferredScrollableViewportSize:[1000, 200]) {
						tableFormat = defaultTableFormat(columnNames: model.columns)
						eventTableModel(source: model.settings, format: tableFormat)
					}
				}
			}

		}