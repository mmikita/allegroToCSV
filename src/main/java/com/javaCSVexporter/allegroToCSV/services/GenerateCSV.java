package com.javaCSVexporter.allegroToCSV.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.javaCSVexporter.allegroToCSV.model.File;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class GenerateCSV {

    private static final String STRING_ARRAY_SAMPLE = "./string-array-sample.csv";

	public void generate() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
	      try (
	              Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

	              CSVWriter csvWriter = new CSVWriter(writer,
	                      CSVWriter.DEFAULT_SEPARATOR,
	                      CSVWriter.NO_QUOTE_CHARACTER,
	                      CSVWriter.DEFAULT_ESCAPE_CHARACTER,
	                      CSVWriter.DEFAULT_LINE_END);
	          ) {
	    	  StatefulBeanToCsv<File> beanToCsv = new StatefulBeanToCsvBuilder(writer)
	                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	                    .build();

	            List<File> myUsers = new ArrayList<>();
   	  
	            myUsers.add(new File("Hehe Pichai", "sundar.pichai@gmail.com"));
	            
	            beanToCsv.write(myUsers);

	          }

	}
	
}
