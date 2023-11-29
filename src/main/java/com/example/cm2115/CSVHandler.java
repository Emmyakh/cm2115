package com.example.cm2115;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The CSVHandler class provides utility methods for reading, writing, and appending data
 * to CSV files. It utilizes the opencsv and commons-csv libraries for CSV operations.
 */
public class CSVHandler {

    /**
     * Reads data from a CSV file and returns a list of string arrays.
     *
     * @param filePath The path of the CSV file to be read.
     * @return A list of string arrays representing the CSV data.
     * @throws IOException If an I/O error occurs during the reading process.
     */
    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();

        // Use try-with-resources to ensure proper resource management
        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            // Iterate through CSV records and convert them to string arrays
            for (CSVRecord record : csvParser) {
                String[] values = new String[record.size()];
                for (int i = 0; i < record.size(); i++) {
                    values[i] = record.get(i);
                }
                data.add(values);
            }
        }

        return data;
    }

    /**
     * Writes data to a CSV file, overwriting existing content.
     *
     * @param filePath The path of the CSV file to be written.
     * @param data     The list of string arrays representing the data to be written.
     * @throws IOException If an I/O error occurs during the writing process.
     */
    public static void writeCSV(String filePath, List<String[]> data) throws IOException {
        // Use try-with-resources to ensure proper resource management
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, false))) {
            writer.writeAll(data);
        }
    }

    /**
     * Appends data to a CSV file without overwriting existing content.
     *
     * @param filePath The path of the CSV file for data appending.
     * @param data     The list of string arrays representing the data to be appended.
     * @throws IOException If an I/O error occurs during the appending process.
     */
    public static void appendtoCSV(String filePath, List<String[]> data) throws IOException {
        // Use try-with-resources to ensure proper resource management
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
            writer.writeAll(data);
        }
    }
}
