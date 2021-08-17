package com.AddressBookSystemLambda;

import java.text.ParseException;

public class AddressBookMain {

    public static void main(String[] args) throws ParseException {
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
