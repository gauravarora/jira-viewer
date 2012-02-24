package jira.viewer3

import org.swift.common.soap.jira.JiraSoapServiceServiceLocator

class JiraViewer3Controller {
	// these will be injected by Griffon
	def model
	def view

	def act = { evt = null ->
		def server = 'http://jira.iontrading.com' // like http://xxxx:port
		def user = 'garora'	// like automation
		def password = 'gaurav' // like automation
		def storypointId = 'customfield_11573'
		def filename = 'all.csv'

		def url = "${server}/rpc/soap/jirasoapservice-v2"

		println "JIRA soap url: ${url}"

		def serviceLocator = new JiraSoapServiceServiceLocator()
		serviceLocator.setJirasoapserviceV2EndpointAddress(url)
		serviceLocator.setMaintainSession(true)

		def service = serviceLocator.getJirasoapserviceV2()
		def token = service.login(user, password)

		def info = service.getServerInfo(token)
		println "JIRA version: ${info.getVersion()}"  // just verifies things are working

		//def issues = service.getIssuesFromJqlSearch(token, "project = BOREENG AND status = Open AND \"Story Points\" >= 1 ORDER BY priority DESC",10)
		def issues = service.getIssuesFromJqlSearch(token, "project = BOREENG AND status = Open AND \"Story Points\" >= 0 ORDER BY priority DESC",20)
		def map = [:]
		issues.each { r->
			def splist = r.customFieldValues.findAll{it.customfieldId.equals(storypointId)}.collect {it.values }
			def sp = splist[0][0]
			//println r.summary + " - " + sp + " - " + sp.class.name
			def m = map.get(sp)
			if (!m) {
				m = []
				map.put(sp, m)
			}
			m << r.summary
		}

		def max = 0
		map.each { k, v ->
			println k
			if (v.size > max) {
				max = v.size
			}
			v.each { println it }
		}
		println "max is " + max
		for (int i = 0; i < max; i++) {
			def m = [:]
			map.each { k, v ->
				m.put(k, v[i])
			}
			println "m is " + m
			model.settings << m
		}
	}
}
