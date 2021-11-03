package org.paumard.devoxxuk2021;

import org.paumard.devoxxuk2021.legacy.RangeLegacy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class G_PlayWithRecordAndSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        var range = new RangeLegacy(10, 0);
//        System.out.println("range = " + range);
//
//        var fos = Files.newOutputStream(Path.of("files/range-legacy-10-0.dat"));
//        var oos = new ObjectOutputStream(fos);
//
//        oos.writeObject(range);

        var is = Files.newInputStream(Path.of("files/range-legacy-10-0.dat"));
        var ois = new ObjectInputStream(is);
        System.out.println("Reading range");
        var readRange = ois.readObject();
        System.out.println("readRange = " + readRange);
    }
}