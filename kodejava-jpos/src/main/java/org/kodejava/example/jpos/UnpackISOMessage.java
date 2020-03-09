package org.kodejava.example.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.io.InputStream;

public class UnpackISOMessage {
    public static void main(String[] args) {
        UnpackISOMessage iso = new UnpackISOMessage();
        try {
            ISOMsg isoMsg = iso.parseISOMessage();
            iso.printISOMessage(isoMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 00110010 00100000 00000000 00000000 00000000 10000000 10000000 00000000
    // 02003220000000808000000010000000001500120604120000000112340001840
    // 0010000000111000000000010000000000000010110000000000000000000110
    private ISOMsg parseISOMessage() throws Exception {
        String message = "08102038010002c00006" +
            "920000683279112903072200413030383030303030363820202020202020202020202020202000859bcb28c3168d11ee000000000000000054455354494e47205445414d205448414e4520202020205448414e452020202020202020204d48202020202020202020202020202020202020202020202020202020202020003600344b509bcb28c2e08d11eebbe04de6eb78a79c48bbb4f43f0f759171846d85cd4d584d00000000000000000000000000000000000000000000000000000000000000000000000000000000";

        //message = "081020380000028000029800000000961221380905303031303030303130370061005937316493f2a48e365938b5dbc8a667235f3e366d0605b7f54a3c1f03e205707b331f757d4a967a76d9842c3f9a284b65526e303c174496d92e30ed";
        System.out.printf("Message = %s%n", message);
        try {
            // Load package from resources directory.
            InputStream is = getClass().getResourceAsStream("/iso87ascii.xml");
            GenericPackager packager = new GenericPackager(is);
            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.unpack(message.getBytes());
            return isoMsg;
        } catch (ISOException e) {
            throw new Exception(e);
        }
    }

    private void printISOMessage(ISOMsg isoMsg) {
        try {
            System.out.printf("MTI = %s%n", isoMsg.getMTI());
            for (int i = 1; i <= isoMsg.getMaxField(); i++) {
                if (isoMsg.hasField(i)) {
                    System.out.printf("Field (%s) = %s%n", i, isoMsg.getString(i));
                }
            }
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }
}
