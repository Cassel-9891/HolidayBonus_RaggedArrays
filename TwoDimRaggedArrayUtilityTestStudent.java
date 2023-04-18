/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Junit Tests for the TwoDimRaggedArrayUtility class
 * Due: 04/17/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent 
{
    // double 2D array to use throughout the Tests
    private double[][] numbers = { {1, 2, 3, 4, 5}, 
                                   {4, 5, 6}, 
                                   {7, 8, 9, 10} };

    @Test
    public void getTotal()
    {
        // Arrange
        double expectedTotalNumbers = 64;

        // Act
        double results = TwoDimRaggedArrayUtility.getTotal(numbers);

        // Assert
        assertEquals(expectedTotalNumbers, results, 0.001);
    }

    @Test
    public void getAverage()
    {
        // Arrange
        double expectedAverage = 5.333;

        // Act
        double results = TwoDimRaggedArrayUtility.getAverage(numbers);

        // Assert
        assertEquals(expectedAverage, results, 0.001);
    }

    @Test
    public void getRowTotal()
    {
        // Arrange
        double expectedRowTotal = 15;

        // Act
        double results = TwoDimRaggedArrayUtility.getRowTotal(numbers, 1);

        // Assert
        assertEquals(expectedRowTotal, results, 0.001);
    }

    @Test
    public void getColumnTotal()
    {
        // Arrange
        double expectedColumnTotal = 14;

        // Act
        double results = TwoDimRaggedArrayUtility.getColumnTotal(numbers, 3);

        // Assert
        assertEquals(expectedColumnTotal, results, 0.001);
    }

    @Test
    public void getHighestInRow()
    {
        // Arrange
        double expectedHighestInRow = 10; 

        // Act
        double results = TwoDimRaggedArrayUtility.getHighestInRow(numbers, 2);

        // Assert
        assertEquals(expectedHighestInRow, results, 0.001);
    }

    @Test
    public void getHighestInRowIndex()
    {
        // Arrange
        int expectedHighestInRowIndex = 3;

        // Act
        int results = TwoDimRaggedArrayUtility.getHighestInRowIndex(numbers, 2);

        // Assert
        assertEquals(expectedHighestInRowIndex, results);
    }

    @Test
    public void getLowestInRow()
    {
        // Arrange
        double expectedLowestInRow = 1;

        // Act
        double results = TwoDimRaggedArrayUtility.getLowestInRow(numbers, 0);

        // Assert
        assertEquals(expectedLowestInRow, results, 0.001);
    }

    @Test
    public void getLowestInRowIndex()
    {
        // Arrange
        int expectedLowestInRowIndex = 0;

        // Act
        int results = TwoDimRaggedArrayUtility.getLowestInRowIndex(numbers, 1);

        // Assert
        assertEquals(expectedLowestInRowIndex, results);
    }

    @Test
    public void getHighestInColumn()
    {
        // Arrange
        double expectedHighestInColumn = 10;

        // Act
        double results = TwoDimRaggedArrayUtility.getHighestInColumn(numbers, 3);

        // Assert
        assertEquals(expectedHighestInColumn, results, 0.001);
    }

    @Test
    public void getHighestInColumnIndex()
    {
        // Arrange
        int expectedHighestInColumnIndex = 2;

        // Act
        int results = TwoDimRaggedArrayUtility.getHighestInColumnIndex(numbers, 3);

        // Assert
        assertEquals(expectedHighestInColumnIndex, results);
    }

    @Test
    public void getLowestInColumn()
    {
        // Arrange
        double expectedLowestInColumn = 4;

        // Act
        double results = TwoDimRaggedArrayUtility.getLowestInColumn(numbers, 3);

        // Assert
        assertEquals(expectedLowestInColumn, results, 0.001);
    }

    @Test
    public void getLowestInColumnIndex()
    {
        // Arrange
        int expectedLowestInColumnIndex = 0;

        // Act
        int results = TwoDimRaggedArrayUtility.getLowestInColumnIndex(numbers, 3);

        // Assert
        assertEquals(expectedLowestInColumnIndex, results);
    }

    /* I added this test to fix the problem with negative numbers, where the bonuses 
    should not be given to negative sales but still have my original function that 
    gives you the absolute minimum value even if negative */
    @Test
    public void getLowestPositiveInColumnIndex()
    {
        // Arrange
        double[][] numbersWithNegative = { 
            {1, 2, 3, 4, 5}, 
            {-4, 5, 6}, 
            {7, 8, 9, 10} 
        };

        int expectedLowestInColumnIndex = 0;

        // Act
        int results = TwoDimRaggedArrayUtility.getLowestPositiveInColumnIndex(numbersWithNegative, 0);

        // Assert
        assertEquals(expectedLowestInColumnIndex, results);
    }

    @Test
    public void getHighestInArray()
    {
        // Arrange
        double expectedHighestValue = 10;

        // Act
        double results = TwoDimRaggedArrayUtility.getHighestInArray(numbers);

        // Assert
        assertEquals(expectedHighestValue, results, 0.001);
    }

    @Test
    public void getLowestInArray()
    {
        // Arrange
        double expectedLowestValue = 1;

        // Act
        double results = TwoDimRaggedArrayUtility.getLowestInArray(numbers);

        // Assert
        assertEquals(expectedLowestValue, results, 0.001);
    }

}
