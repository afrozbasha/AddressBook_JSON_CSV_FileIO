package com.AddressBookSystemLambda;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;

public class CSVFile {
    String filePath = "C:\\Users\\afroz\\Documents\\BridgeLabz\\javaIntellij\\AddressBookSystemLambda\\src\\com\\AddressBookSystemLambda\\AddressBook.csv";

    public void writeCSVFile(ArrayList<AddressBookBluePrint> detailedEntries) throws IOException {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);

            String[] header = {"FirstName", "LastName", "Address", "City", "State", "Zip", "PhoneNumber", "Email"};
            writer.writeNext(header);

            detailedEntries.forEach(addressBookBluePrint -> {
                String[] person = {addressBookBluePrint.getFirstName(), addressBookBluePrint.getLastName(),
                        addressBookBluePrint.getAddress(), addressBookBluePrint.getCity(), addressBookBluePrint.getState(),
                        String.valueOf(addressBookBluePrint.getZip()), String.valueOf(addressBookBluePrint.getMobileNum()), addressBookBluePrint.geteMail()};
                writer.writeNext(person);
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSVFile() throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] personElement;

            while ((personElement = csvReader.readNext()) != null){
                for (String cell : personElement){
                    System.out.println(cell + "\t");
                }
                System.out.printf("\n");
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
