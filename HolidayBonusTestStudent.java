/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Junit Tests for the Holiday Bonus class
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

public class HolidayBonusTestStudent 
{

    private double[][] testData = {
        {1253.65, 4.50,     2154.36, 7532.45, 3388.44},
        {2876.22, -3.24,    1954.66},
        {4896.23, 2.29,     5499.29},
        {2256.76, 3.76,     4286.29, 5438.48, 3794.43},
        {3184.38, 3654.65,  3455.76, 6387.23, 4265.77,  4592.45},
        {2657.46, 3265.34,  2256.38, 8935.26, 5287.34,  6598.23}
    };

     @Test
    public void calculateHolidayBonus()
    {
        //Arrange                               
        double[] expectedHolidayBonus = { 8000.00, 4000.00, 12000.00, 9000.00, 14000.00, 21000.00 };

        //Act
        double[] result = HolidayBonus.calculateHolidayBonus(testData);

        //Assert
        assertArrayEquals(null, expectedHolidayBonus, result, 0.001);
    }

    @Test
    public void calculateTotalHolidayBonus()
    {
        //Arrange
        double expectedTotalBonus = 68000;

        //Act
        double result = HolidayBonus.calculateTotalHolidayBonus(testData);

        //Assert
        assertEquals(expectedTotalBonus, result, 0.001);
    }
}
