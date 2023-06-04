package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile extends Collection {

        public static void writeToFile() {
        String path = "C:\\Users\\drisy\\IdeaProjects\\RFP272-AddressBookSystem\\src\\com\\bridgelabz\\AddressBook.txt";
        StringBuffer addressBookBuffer = new StringBuffer();
        addressBookMap.values().stream().forEach(contact -> {
            String personDataString = contact.toString().concat("\n");
            addressBookBuffer.append(personDataString);
        });

        try {
            Files.write(Paths.get(path), addressBookBuffer.toString().getBytes());
        }
        catch (IOException e) {
            System.out.println("Catch block");
        }
    }

    public static void readFromFile() {
        String path = "C:\\Users\\drisy\\IdeaProjects\\RFP272-AddressBookSystem\\src\\com\\bridgelabz\\AddressBook.txt";
        System.out.println("Reading from : " + path + "\n");
        try {
            Files.lines(new File(path).toPath()).forEach(employeeDetails -> System.out.println(employeeDetails));
        }
        catch(IOException e){
            System.out.println("Catch block");
        }
    }

    public static void writeToCSVFile() {

        FileWriter fileWriter = null;
        String filePath = "C:\\Users\\drisy\\IdeaProjects\\REF272_AddressBookSystem-Day28\\src\\main\\java\\com\\bridgelabz\\AddressBook.csv";

        try {
            fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSVWriter writer = new CSVWriter(fileWriter);
        List<String[]> csvLines = new ArrayList<>();

        addressBookMap.keySet().stream().forEach(bookName -> addressBookMap.get(bookName).getContact()
                .stream().forEach(contact -> csvLines.add(new String[]{contact.toString()})));


        writer.writeAll(csvLines);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromCSVFile() {

        String filePath = "C:\\Users\\drisy\\IdeaProjects\\REF272_AddressBookSystem-Day28\\src\\main\\java\\com\\bridgelabz\\AddressBook.csv";
        FileReader fileReader =null;
        try {
            fileReader = new FileReader(filePath);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
        List<String[]> linesOfData = null;
        try {
            linesOfData = csvReader.readAll();
        }catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        System.out.println("\nReading data from csv file:");
        linesOfData.stream().forEach(lines -> {
            for (String value : lines)
                System.out.print(value + "\t");
            System.out.println();
        });
        try {
            csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();

        }
    }
}
