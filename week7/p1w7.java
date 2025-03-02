package week7;
import java.io.*;
import java.util.*;

// Custom exception for invalid data
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

class DataProcessor {
    
    // Method to read values from file
    public List<Double> readValuesFromFile(String filePath) {
        List<Double> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    values.add(Double.parseDouble(line.trim()));
                } catch (NumberFormatException e) {
                    throw new InvalidDataException("Invalid numeric data found: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.out.println("Data validation error: " + e.getMessage());
        }
        return values;
    }
    
    // Method to validate data
    public List<Double> validateData(List<Double> values) {
        List<Double> validValues = new ArrayList<>();
        for (Double value : values) {
            if (value != null) {
                validValues.add(value);
            }
        }
        return validValues;
    }
    
    // Method to calculate the average
    public double calculateAverage(List<Double> validValues) {
        if (validValues.isEmpty()) return 0;
        double sum = 0;
        for (double value : validValues) {
            sum += value;
        }
        return sum / validValues.size();
    }
    
    // Method to write result to file
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
        String inputFilePath = "input.txt"; // Change to your file path
        String outputFilePath = "output.txt";
        
        // Read, validate, calculate and write
        List<Double> values = processor.readValuesFromFile(inputFilePath);
        List<Double> validValues = processor.validateData(values);
        double average = processor.calculateAverage(validValues);
        processor.writeResultToFile(average, outputFilePath);
    }
}
