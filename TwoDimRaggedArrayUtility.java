/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Manipulates data from and to a file in the form of arrays to find maxs and mins and other info
 * Due: 04/17/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility 
{
    public static final int MAX_ROW = 10;
    public static final int MAX_COLUMN = 10;

    public static double[][] readFile(File file) throws FileNotFoundException
    {

        // Creating a temporary empty 2D array
        String[][] temp = new String[MAX_ROW][MAX_COLUMN];

        // This variable will hold the amount of rows in the String 2D array
        int currentRow = 0;

        // Creates scanner object to read from file
        try (Scanner inputFile = new Scanner(file)) 
        {
            while(inputFile.hasNextLine()) // Reads until the end of a file
            {
                // String variable to hold line by line the contents of the file
                String rowContent = inputFile.nextLine();

                // Using split method to separate the String line into elements divided by a space
                // This elements will represent the columns of each row
                String[] columns = rowContent.split(" ");  

                // Passing into the every row the corresponding columns
                // to fill in the previously empty String array 
                temp[currentRow] = columns;

                // Goes to next line (row) in the file to start process over
                currentRow++;
            }
        }

        // Create a double type array and pass in the right amount of rows
        double[][] sales = new double[currentRow][];

        // Get the right amount of columns for each row of the sales array
        for (int rowIndex = 0; rowIndex < sales.length; rowIndex++) 
        {
            // Extracting amount of columns in each row
            int columnCount = temp[rowIndex].length;

            // Creating the right amount of columns per row and 
            // assigning them to the sales 2D array
            sales[rowIndex] = new double[columnCount];

            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) 
            {
                // Grabbing the elements of temp array and saving them to a variable to parse next 
                String tempElement = temp[rowIndex][columnIndex];

                // Parsing from String to double and saving it in a variable 
                double salesElement = Double.parseDouble(tempElement);

                // Passing each double elements to fill in the ragged sales array
                sales[rowIndex][columnIndex] = salesElement;
            }
        }

        return sales;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
    {
        try (PrintWriter writer = new PrintWriter(outputFile)) 
        {            
			String fileContent = "";
            int rowsInArray = data.length;

            for (int rowIndex = 0; rowIndex < rowsInArray; rowIndex++) 
            {                
                for (int colIndex = 0; colIndex < data[rowIndex].length; colIndex++) 
                {
                    String currentElement = Double.toString(data[rowIndex][colIndex]);
                    int lastElementIndex = data[rowIndex].length - 1;

                    fileContent += currentElement;
                    if (colIndex != lastElementIndex) 
                    {
                        fileContent += " ";
                    }    
                }

                int lastRowIndex = rowsInArray - 1;
                if (rowIndex != lastRowIndex) 
                {
                    fileContent += "\n";
                }
				
            }
			
            writer.print(fileContent);
        }
        
    }

    public static double getTotal(double[][] data)
    {
        double total = 0; // running total
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            total += getRowTotal(data, rowIndex);
        }

        return total;
    }

    public static double getAverage (double[][] data)
    {   
        int totalNumberOfElements = 0;
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            totalNumberOfElements += data[rowIndex].length; 
        }

        // total sum / num of elements in 2D array
        return getTotal(data) / totalNumberOfElements;
    }

    public static double getRowTotal(double[][] data, int row)
    {
        double total = 0; // running total

        // a reference variable (pointing at the same address in memory)
        // for clarity of reading code purposes
        double[] rowData = data[row]; 

        for (int columnIndex = 0; columnIndex < rowData.length; columnIndex++) 
        {
            total += rowData[columnIndex];
        }

        return total;
    }

    public static double getColumnTotal (double[][] data, int col)
    {
        double total = 0; // running total
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            int lastElementIndex = data[rowIndex].length - 1;
            if (lastElementIndex >= col) 
            {
                total += data[rowIndex][col];
            }
        }

        return total;
    }

    public static double getHighestInRow(double[][] data, int row)
    {
        // saves results of getHighestInRowIndex to then locate the higuest number in that row
        int highestColumnInRow = getHighestInRowIndex(data, row);

        // returns the higuest number in that row found by getHighestInRowIndex method
        return data[row][highestColumnInRow];
    }

    public static int getHighestInRowIndex(double[][] data, int row)
    {
        // Initializing highest in row to first element to start comparison in loop
        int highestInRowIndex = 0;
        int rowLength = data[row].length;
        
        for (int currentColumnIndex = 1; currentColumnIndex < rowLength; currentColumnIndex++) 
        {
            // selecting first row element value as highest to compare in
            // if-statement with every next value in row 
            double highestValueInRow = data[row][highestInRowIndex];

            // as the for-loop moves forward current element will be next value in the row
            double currentElement = data[row][currentColumnIndex];
            if(highestValueInRow < currentElement) 
            {
                highestInRowIndex = currentColumnIndex;
            }
        }

        return highestInRowIndex;
    }

    public static double getLowestInRow(double[][] data, int row)
    {
        // saves results of getLowestInRowIndex to then locate the lowest number in that row
        int lowestColumnIndex = getLowestInRowIndex(data, row);

        // returns the lowest number in that row found by getlowestInRowIndex method
        return data[row][lowestColumnIndex];
    }

    public static int getLowestInRowIndex(double[][] data, int row)
    {
        // Initializing lowest in row to first element to start comparison in loop
        int lowestInRowIndex = 0;
        int rowLength = data[row].length;

        for (int columnIndex = 1; columnIndex < rowLength; columnIndex++) 
        {
            // selecting first row element value as lowest to compare in
            // if-statement with every next value in row 
            double lowestValueInRow = data[row][lowestInRowIndex];

            // as the for-loop moves forward current element will be next value in the row
            double currentElement = data[row][columnIndex];
            if(lowestValueInRow > currentElement) 
            {
                lowestInRowIndex = columnIndex;
            }
        }

        return lowestInRowIndex;
    }

    public static double getHighestInColumn(double[][] data, int col)
    {
        // saves results of getHighestInColumnIndex to then locate the highest number in that col
        int highestRowIndex = getHighestInColumnIndex(data, col);

        // returns the highest number in that col found by getHighestInColumnIndex method
        return data[highestRowIndex][col];
    }

    public static int getHighestInColumnIndex(double[][] data, int col)
    {
        int rowIndexWithHighestValue = -1;
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            // Extracts the last index of the current row to see later if 
            // the column passed in exists in that row
            int lastElementIndex = data[rowIndex].length - 1;
            if (lastElementIndex >= col) // checks to see if the column exists
            {
                // if the column index still reads -1 then the current column index in the loop
                // is assumed to be the highest 
                if (rowIndexWithHighestValue == -1) 
                {
                    // This will always be true for the first loop where the column does exists
                    rowIndexWithHighestValue = rowIndex;
                }

                double highestInColumnValue = data[rowIndexWithHighestValue][col];
                double currentValue = data[rowIndex][col];
                if(highestInColumnValue < currentValue)
                {
                    rowIndexWithHighestValue = rowIndex;
                }
            }
        }
        return rowIndexWithHighestValue;
    }

    public static double getLowestInColumn(double[][] data, int col)
    {
        // saves results of getLowestInColumnIndex to then locate the lowest number in that column
        int lowestRowIndex = getLowestInColumnIndex(data, col);

        // returns the lowest number in that column found by getLowestInColumnIndex method
        return data[lowestRowIndex][col];
    }

    public static int getLowestInColumnIndex(double[][] data, int col)
    {
        int rowIndexWithLowestValue = -1;
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            // Extracts the last index of the current row to see later if 
            // the column passed in exists in that row
            int lastElementIndex = data[rowIndex].length - 1;
            if (lastElementIndex >= col) // checks to see if the column exists
            {
                // if the column index still reads -1 then the current column index in the loop
                // is assumed to be the lowest 
                if (rowIndexWithLowestValue == -1) 
                {
                    // This will always be true for the first loop where the column does exists
                    rowIndexWithLowestValue = rowIndex;
                }

                double lowestInColumnValue = data[rowIndexWithLowestValue][col];
                double currentValue = data[rowIndex][col];
                if(lowestInColumnValue > currentValue)
                {
                    rowIndexWithLowestValue = rowIndex;
                }
            }
        }
        return rowIndexWithLowestValue;
    }

    public static int getLowestPositiveInColumnIndex(double[][] data, int col)
    {
        int rowIndexWithLowestValue = -1;
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
        {
            // Extracts the last index of the current row to see later if 
            // the column passed in exists in that row
            int lastElementIndex = data[rowIndex].length - 1;
            if (lastElementIndex >= col) // checks to see if the column exists
            {
                // if the column index still reads -1 then the current column index in the loop
                // is assumed to be the lowest 
                if (rowIndexWithLowestValue == -1) 
                {
                    // This will always be true for the first loop where the column does exists
                    rowIndexWithLowestValue = rowIndex;
                }

                // finds the lowest value that is not negative and returns the index
                double lowestInColumnValue = data[rowIndexWithLowestValue][col];
                double currentValue = data[rowIndex][col];
                if(lowestInColumnValue > currentValue && currentValue > 0)
                {
                    rowIndexWithLowestValue = rowIndex;
                }
            }
        }
        return rowIndexWithLowestValue;
    }

    public static double getHighestInArray(double[][] data)
    {
        int rowsIntheArray = data.length;
        double highestInArray = getHighestInRow(data, 0);
        for (int row = 1; row < rowsIntheArray; row++) 
        {
            double highestInCurrentRow = getHighestInRow(data, row);
            if (highestInArray < highestInCurrentRow) 
            {
                highestInArray = highestInCurrentRow;
            }
        }
        return highestInArray;
    }

    public static double getLowestInArray (double[][] data)
    {
        int rowsIntheArray = data.length;
        double lowestInArray = getLowestInRow(data, 0);
        for (int row = 1; row < rowsIntheArray; row++) 
        {
            double lowestInCurrentRow = getLowestInRow(data, row);
            if (lowestInArray > lowestInCurrentRow) 
            {
                lowestInArray = lowestInCurrentRow;
            }
        }
        return lowestInArray;
    }
}
