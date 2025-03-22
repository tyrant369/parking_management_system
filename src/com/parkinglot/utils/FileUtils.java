package com.parkinglot.utils;

import java.io.*;

public class FileUtils {

    private static final String FILE_NAME = "parking_lot_data.bin";

    // serializable and save data to a binary file
    public static void saveToFile(Object data) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){

            System.out.println("data in file util:");


            System.out.println(data);

            oos.writeObject(data);

            System.out.println("Data Saved to File: " + FILE_NAME);

        }

        catch (IOException e) {

            System.out.println("Error in File Saving: " + e.getMessage());
        }
    }

    // deserialize and load data from a binary file
    public static Object loadFromFile() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){

            return ois.readObject();
        }

        catch (IOException | ClassNotFoundException e) {

            System.out.println("Error in Loading Data: " + e.getMessage());

            return null;
        }
    }
}
