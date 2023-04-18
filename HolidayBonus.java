import java.util.Arrays;

/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Calculates bonuses from 2D array to get bonuses to a report
 * Due: 04/17/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/
public class HolidayBonus 
{
    private final static double MAX_BONUS = 5000.0;
    private final static double MIN_BONUS = 1000.0;
    private final static double STANDARD_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data)
    {
        // amount of stores in the district
        int stores = data.length;

        // array representing bonuses for each store
        double[] storeBonuses = new double[stores];

        // Fill the array with zeros as to be able to sum with bonuses later
        Arrays.fill(storeBonuses, 0);

        // Rows represent the stores in a district 
        int maxCol = 0;
        for (int rowIndex = 0; rowIndex < stores; rowIndex++) 
        {
            // Math max function to return the max of two numbers
            maxCol = Math.max(maxCol, data[rowIndex].length);
        }
        
        // columns represent categories of sales
        for (int colIndex = 0; colIndex < maxCol; colIndex++) 
        {
            // stores the index of the row where it finds the highest value for the current column
            int highestRowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, colIndex);
            storeBonuses[highestRowIndex] += MAX_BONUS;

            // stores the index of the row where it finds the lowest value for the current column
            int lowestRowIndex = TwoDimRaggedArrayUtility.getLowestPositiveInColumnIndex(data, colIndex);
            if(highestRowIndex != lowestRowIndex)
            {
                storeBonuses[lowestRowIndex] += MIN_BONUS;
            }

            for (int row = 0; row < stores; row++) 
            {
                    if(row != lowestRowIndex // eliminates the lowest earner
                        && row != highestRowIndex // eliminates the highest earner
                        && data[row].length - 1 >= colIndex // eliminates stores who don't have that category
                        && data[row][colIndex] > 0) // eliminates the negative earners
                    {
                        storeBonuses[row] += STANDARD_BONUS;
                    }
            }            
        }    

        return storeBonuses;
    }
    
    public static double calculateTotalHolidayBonus(double[][] data)
    {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double storeBonus : bonuses) 
        {
            total += storeBonus;
        }

        return total;
    }
    
}
