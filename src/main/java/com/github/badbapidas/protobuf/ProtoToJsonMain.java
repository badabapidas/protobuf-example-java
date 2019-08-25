package com.github.badbapidas.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple.SimpleMessage.Builder builder= Simple.SimpleMessage.newBuilder();
        // simple fields
        builder.setId(50)
                .setName("Bapi")
                .setIsSimple(true);

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        // Print this as a json
        String jsonString= JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        // parse json to protobuf message
        System.out.println("Json to Protobuf");
        Simple.SimpleMessage.Builder builder2= Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2);

    }
}
