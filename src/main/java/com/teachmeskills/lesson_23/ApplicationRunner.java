package com.teachmeskills.lesson_23;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.teachmeskills.lesson_23.parser.XMLParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import com.teachmeskills.lesson_23.model.Book;
import com.teachmeskills.lesson_23.model.BookListWrapper;
import java.io.File;


public class ApplicationRunner {
    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try {
            //1. Use the Jackson library, write a Java program that reads a JSON file (books.json) and stores the data in a Java collection.
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            Book[] books = mapper.readValue(new File("books.json"), Book[].class);

            //2. Convert data from this collection to XML format using the JAXB library. Save the resulting XML result to a file.
            JAXBContext context = JAXBContext.newInstance(BookListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new BookListWrapper(books), new File("books.xml"));

            //3. Using any parser (DOM, SAX, StAX) parse the data in a Java application and display information about the book with the largest number of pages to the console.
            XMLParser xmlParser = new XMLParser();
            xmlParser.parseXML("books.xml");

        }catch (Exception e){
            System.out.println("General JSON to XML Conversion Error: " + e.getMessage());
        }
    }
}
