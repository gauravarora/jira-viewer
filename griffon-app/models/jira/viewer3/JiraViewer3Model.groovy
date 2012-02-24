package jira.viewer3

import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList
import groovy.beans.Bindable

class JiraViewer3Model {
   // @Bindable String propName
	EventList settings = new BasicEventList(100)
	
	def columns = ['0', '0.5', '1', '2', '3', '5', '8', '13']
}