package com.AddressBookSystemLambda;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class JSONFile {
    String filePath = "C:\\Users\\afroz\\Documents\\BridgeLabz\\javaIntellij\\AddressBookSystemLambda\\src\\com\\AddressBookSystemLambda\\AddressBook.json";
    public void readJsonFile() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray;

        try{
            FileReader reader = new FileReader(filePath);
            jsonArray = (JSONArray) jsonParser.parse(reader);
            System.out.println(jsonArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonFile(ArrayList<AddressBookBluePrint> detailedEntries){
        try {
            JSONArray jsonArray = new JSONArray();
            detailedEntries.forEach(addressBookBluePrint -> {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("First name", addressBookBluePrint.getFirstName());
                jsonObject.put("Last name", addressBookBluePrint.getLastName());
                jsonObject.put("Address", addressBookBluePrint.getAddress());
                jsonObject.put("City", addressBookBluePrint.getCity());
                jsonObject.put("State", addressBookBluePrint.getState());
                jsonObject.put("Email", addressBookBluePrint.geteMail());
                jsonObject.put("Zip", addressBookBluePrint.getZip());
                jsonObject.put("Mobile num", addressBookBluePrint.getMobileNum());
                jsonArray.add(jsonObject);
            });
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
