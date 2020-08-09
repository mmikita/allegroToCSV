package com.javaCSVexporter.allegroToCSV.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaCSVexporter.allegroToCSV.services.GenerateCSV;

public class MainControllerData {
	@Autowired
	public GenerateCSV service;

	public MainControllerData() {
	}
}