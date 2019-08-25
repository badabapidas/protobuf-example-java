package com.github.badbapidas.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world");

        SimpleMessage.Builder builder= SimpleMessage.newBuilder();
        // simple fields
        builder.setId(50)
                .setName("Bapi")
                .setIsSimple(true);

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());

        SimpleMessage message= builder.build();
        // write the protocol buffer binary to a file
        try {
            FileOutputStream outputStream= new FileOutputStream("simpmle_messsage.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send in a network
        byte[] bytes= message.toByteArray();


        try {
            // read the data
            System.out.println("Reading from a file...");
            FileInputStream fileInputStream = new FileInputStream("simpmle_messsage.bin");
           SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
           System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
