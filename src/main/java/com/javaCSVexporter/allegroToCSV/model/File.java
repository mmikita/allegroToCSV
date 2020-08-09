package com.javaCSVexporter.allegroToCSV.model;

import org.springframework.stereotype.Controller;

import com.opencsv.bean.CsvBindByName;

@Controller
public class File {
	
	@CsvBindByName
    private String id;
    public File(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
    public File() {
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@CsvBindByName
    private String name;

}
