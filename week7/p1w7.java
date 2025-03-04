package week7;
import java.io.*;
import java.util.*;

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

class DataProcessor {
    
    // Reads numeric values from a file, collecting invalid entries
    public List<Double> readValuesFromFile(String filePath, List<String> invalidEntries) {
        List<Double> values = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    values.add(Double.parseDouble(line.trim()));  // Parse number
                } catch (NumberFormatException e) {
                    invalidEntries.add(line.trim());  // Store invalid data
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return values;
    }

    // Validates and returns only valid numbers
    public List<Double> validateData(List<Double> values) {
        List<Double> validValues = new ArrayList<>();
        for (Double value : values) {
            if (value != null) {
                validValues.add(value);
            }
        }
        return validValues;
    }

    public double calculateAverage(List<Double> validValues) {
        if (validValues.isEmpty()) return 0;
        double sum = 0;
        for (double value : validValues) {
            sum += value;
        }
        return sum / validValues.size();
    }

    public void writeResultToFile(double average, String outputPath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            bw.write("Average: " + average);
            System.out.println("Average successfully written to file: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class p1w7 {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        String inputFilePath = "input.txt"; 
        String outputFilePath = "output.txt";
        List<String> invalidEntries = new ArrayList<>();  // Stores invalid values

        List<Double> values = processor.readValuesFromFile(inputFilePath, invalidEntries);
        List<Double> validValues = processor.validateData(values);
        double average = processor.calculateAverage(validValues);
        processor.writeResultToFile(average, outputFilePath);

        // Throw error AFTER processing, without stopping execution
        if (!invalidEntries.isEmpty()) {
            System.out.println("Data validation error: Invalid numeric data found: " + invalidEntries);
        }
    }
}
