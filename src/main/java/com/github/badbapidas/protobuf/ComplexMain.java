package com.github.badbapidas.protobuf;

import example.complex.Complex.*;
import example.complex.Complex.DummyMessage;
import example.complex.Complex.DummyMessage;

public class ComplexMain {
    public static void main(String[] args) {
    System.out.println("Complex Example");

       DummyMessage dummy1 = newDummyMessage(55,"Dummy message");


       ComplexMessage.Builder complexMsgBuilder= ComplexMessage.newBuilder();

        // singular message field
       complexMsgBuilder.setOneDummy(dummy1);

        // repeated field
        complexMsgBuilder.addMultipleDummy(newDummyMessage(12,"second message"))
                .addMultipleDummy(newDummyMessage(88,"third message"))
                .addMultipleDummy(newDummyMessage(66,"fourth message"));

        ComplexMessage message= complexMsgBuilder.build();
        System.out.print(message.toString());
    }

    private static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMsgBuilder= DummyMessage.newBuilder();
        DummyMessage dummyMessage= dummyMsgBuilder.setId(id)
                .setName(name).build();
        return dummyMessage;
    }
}
