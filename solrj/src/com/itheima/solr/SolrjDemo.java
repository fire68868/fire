package com.itheima.solr;

import java.io.IOException;

import javax.print.Doc;
import javax.sound.midi.VoiceStatus;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrjDemo {
	@Test
	public void testEdit() throws Exception{
		String baseURL = "http://localhost:8080/solr/";
		HttpSolrServer solrServer = new HttpSolrServer(baseURL);
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "qian");
		doc.addField("name", "chengliu");
		solrServer.add(doc, 1000);
	}
	
	@Test
	public void testDel() throws Exception{
		String baseURL = "http://localhost:8080/solr/";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		httpSolrServer.deleteByQuery("name:xuexuan", 1000);
	}
	
	@Test
	public void testSelect() throws Exception{
		String baseURL = "http://localhost:8080/solr/";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		QueryResponse query = httpSolrServer.query(solrQuery);
		SolrDocumentList results = query.getResults();
		for (SolrDocument doc : results) {
			System.out.println(doc.get("id"));
			System.out.println(doc.get("name"));
		}
	}
	
}
