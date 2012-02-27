package jira.viewer3

import javax.swing.JTable
import javax.swing.table.TableColumn

actions {
	action(id: 'act', name: 'Fetch', closure: controller.act, mnemonic: 'F', accelerator: shortcut('F'))
}

application(title: 'jira-viewer3',
		preferredSize: [820, 640],
		pack: true,
		//location: [50,50],
		locationByPlatform:true,
		iconImage: imageIcon('/griffon-icon-48x48.png').image,
		iconImages: [
			imageIcon('/griffon-icon-48x48.png').image,
			imageIcon('/griffon-icon-32x32.png').image,
			imageIcon('/griffon-icon-16x16.png').image
		]) {
			busyComponent(id: "c1", busy: bind{model.busy}) {
				busyModel(description: "Executing query")
				panel() {
					gridBagLayout()
					panel(constraints: gridBagConstraints(weightx: 1, weighty: 0.1, gridx:0, gridy: 0)) {
						label('Username: ')
						textField(columns: 10, text: bind('username', target: model, id: 'userbinding'))
						label('Password: ')
						passwordField(columns: 10, text: bind('password', target: model, id: 'passbinding'))
					}
					panel(constraints: gridBagConstraints(weightx: 1, weighty: 0.1, gridx:0, gridy: 1)) {
						label('Query: ')
						textField(columns: 50, text: bind('query', target: model, id: 'querybinding'))
						button(act)
					}
					scrollPane(constraints: gridBagConstraints(fill: BOTH, weightx: 1, weighty: 0.9, gridx:0, gridy: 2)) {
						table = jxtable(id: 'settingsTable', autoResizeMode: JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS,
								autoCreateRowSorter: false, rowSorter: null) {
									tableFormat = defaultTableFormat(columnNames: model.columns)
									eventTableModel(source: model.settings, format: tableFormat)
								}
						for (int i = 0; i < table.getColumnCount(); i++) {
							TableColumn c = table.getColumn(i)
							c.setCellRenderer(new TextAreaRenderer())
						}
					}
				}
			}
		}