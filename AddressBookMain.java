package com.AddressBookSystemLambda;

import java.io.IOException;
import java.text.ParseException;

public class AddressBookMain {

    public static void main(String[] args) throws ParseException, IOException {
        AddressBookManager makeBook = new AddressBookManager();
        makeBook.takeOption();
        boolean condition =true;
        while (condition){
            boolean monitorUser = makeBook.takeOption();
            if (monitorUser)
                break;
        }
    }
}
