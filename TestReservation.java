// Unit test Java source code for testing
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Java TestReservation for John and Janes' B&B
 * Takes information from the tests:
 * .testConstructorAndGetters
 * .testSettersAndGetters
 * .testCalculateReservationNumberOfDays
 * .testCalculateReservationBillAmount
 * .Tests out it with the black-box techniques and checks boundaries
 * This tests out the users' reservation at JJ's B&B, errors, and 
 * if the software code is written correctly
 * Note: This is tested and created through Oracle in Java coding
 * <p>
 * Course: CMSC 345 software engineering principals and techniques
 * <p>
 * Date: 11/26/2024
 * <p>
 * Project: Project 3
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class TestReservation {
    
	/**
	 * datePattern: this is a string for the date when creating reservation objects.
	 * It should do month, day, year.
	 */
    private static String datePattern = "MMM dd, yyyy";
    
    /**
     * SimpleDateFormat: this helps the computer know the date format pattern using the imported java.text.
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

    /**
     * This main function executes the other methods to test the constructors, getters, setters,
     * CalculateReservationNumberOfDays, and CalculateReservationBillAmount.
     * The methods should test it with black-box testing techniques.
     * @param argv  parameter argv to pass in the inputs of the methods.
     * @throws Exception Throws exceptions if the methods or functions are not correctly inputed and other issues.
     */
    public static void main(String argv[]) throws Exception {
        testConstructorAndGetters();
        testSettersAndGetters();
        testCalculateReservationNumberOfDays();
        testCalculateReservationBillAmount();
    }

    /**
     * This method/function tests out the constructor and getters of the Reservation class for users' reservation at JJ's B&B.
     * It should incorporate black-box testing techniques and other checks.
     */
    public static void testConstructorAndGetters() {
        System.out.println();
        System.out.println("Testing Constructor and Getters");
        System.out.println("-------------------------------");
        // Equivalence Partitioning Test Cases
        Reservation r = new Reservation(1,"RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        Reservation r2 = new Reservation(7,"RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        Assert.assertNotEqualsUUID(r.getReservationID(), r2.getReservationID());
        Assert.assertEqualsDate(r.getReservationDate(), new Date());
        
        Assert.assertEqualsInt(r.getGuestID(), 1);
        Assert.assertEqualsString(r.getRoomType(), "RoomWBath");
        Assert.assertEqualsString(r.getReservationStartDate(), "Jun 16, 2022");
        Assert.assertEqualsString(r.getReservationEndDate(), "Jun 19, 2022");
                
        System.out.println();
        System.out.println("Testing Boundary Cases for Constructor and Getters");
        System.out.println("-------------------------------");
                
        // Boundary case for minimal date range
        Reservation r3 = new Reservation(1, "RoomWBath", "Jan 01, 2025", "Jan 02, 2025");
        Assert.assertEqualsString(r3.getReservationStartDate(), "Jan 01, 2025");
        Assert.assertEqualsString(r3.getReservationEndDate(), "Jan 02, 2025");

        // Boundary case for crossing year boundary
        Reservation r4 = new Reservation(2, "RoomWBath", "Dec 31, 2024", "Jan 01, 2025");
        Assert.assertEqualsString(r4.getReservationStartDate(), "Dec 31, 2024");
        Assert.assertEqualsString(r4.getReservationEndDate(), "Jan 01, 2025");

        // Boundary case for leap year
        Reservation r5 = new Reservation(3, "RoomWBath", "Feb 28, 2024", "Mar 01, 2024");
        Assert.assertEqualsString(r5.getReservationStartDate(), "Feb 28, 2024");
        Assert.assertEqualsString(r5.getReservationEndDate(), "Mar 01, 2024");
        
        System.out.println();
        System.out.println("Testing Extra Not Equals and Equals");
        System.out.println("-------------------------------");
        //Testing Not Equals and Equals
        Assert.assertEqualsUUID(r.getReservationID(), r.getReservationID());
        Assert.assertNotEqualsUUID(r3.getReservationID(), r5.getReservationID());
        Assert.assertNotEqualsString(r3.getReservationStartDate(), "Jan 02, 2025");
        Assert.assertNotEqualsInt(r3.getGuestID(), 2);
        Assert.assertEqualsInt(r4.getGuestID(), 2);
        Assert.assertEqualsDate(r.getReservationDate(), r2.getReservationDate());
        Assert.assertNotEqualsDate(r.getReservationDate(), r5.getReservationDate());
    }
    
    /**
     * This method/function tests out the setters and getters of the Reservation class for users' reservation at JJ's B&B.
     * It should incorporate black-box testing techniques and other checks.
     */
    public static void testSettersAndGetters() {
        System.out.println();
        System.out.println("Testing Setters and Getters");
        System.out.println("------------------------------");
        // Equivalence Partitioning Test Cases
        Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r.setGuestID(2);
        r.setRoom("RoomWView");
        r.setReservationStartDate("Jul 01, 2022");
        r.setReservationEndDate("Jul 05, 2022");
        Assert.assertEqualsInt(r.getGuestID(), 2);
        Assert.assertEqualsString(r.getRoomType(), "RoomWView");
        Assert.assertEqualsString(r.getReservationStartDate(), "Jul 01, 2022");
        Assert.assertEqualsString(r.getReservationEndDate(), "Jul 05, 2022");
        
        Reservation r2 = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r2.setGuestID(3);
        r2.setRoom("RoomWBath");
        r2.setReservationStartDate("Aug 01, 2022");
        r2.setReservationEndDate("Aug 10, 2022");
        Assert.assertEqualsInt(r2.getGuestID(), 3);
        Assert.assertEqualsString(r2.getRoomType(), "RoomWBath");
        Assert.assertEqualsString(r2.getReservationStartDate(), "Aug 01, 2022");
        Assert.assertEqualsString(r2.getReservationEndDate(), "Aug 10, 2022");

        Reservation r3 = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r3.setGuestID(4);
        r3.setRoom("NormalRoom");
        r3.setReservationStartDate("Sep 10, 2022");
        r3.setReservationEndDate("Sep 15, 2022");
        Assert.assertEqualsInt(r3.getGuestID(), 4);
        Assert.assertEqualsString(r3.getRoomType(), "NormalRoom");
        Assert.assertEqualsString(r3.getReservationStartDate(), "Sep 10, 2022");
        Assert.assertEqualsString(r3.getReservationEndDate(), "Sep 15, 2022");

        System.out.println();
        System.out.println("Testing Boundary Cases for Setters and Getters");
        System.out.println("-------------------------------");
        // Boundary Value Analysis Test Cases
        Reservation r4 = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r4.setReservationStartDate("Jan 01, 2025");
        r4.setReservationEndDate("Jan 02, 2025");
        Assert.assertEqualsString(r4.getReservationStartDate(), "Jan 01, 2025");
        Assert.assertEqualsString(r4.getReservationEndDate(), "Jan 02, 2025");

        Reservation r5 = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r5.setReservationStartDate("Dec 31, 2024");
        r5.setReservationEndDate("Jan 01, 2025");
        Assert.assertEqualsString(r5.getReservationStartDate(), "Dec 31, 2024");
        Assert.assertEqualsString(r5.getReservationEndDate(), "Jan 01, 2025");

        Reservation r6 = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        r6.setReservationStartDate("Feb 28, 2024");
        r6.setReservationEndDate("Mar 01, 2024");
        Assert.assertEqualsString(r6.getReservationStartDate(), "Feb 28, 2024");
        Assert.assertEqualsString(r6.getReservationEndDate(), "Mar 01, 2024");  
        
        System.out.println();
        System.out.println("Testing Extra Not Equals and Equals");
        System.out.println("-------------------------------");
        //Testing Not Equals and Equals
        Assert.assertNotEqualsInt(r.getGuestID(), 1);
        Assert.assertNotEqualsString(r.getRoomType(), "RoomWView");  // Fails as it equals RoomWView
        Assert.assertNotEqualsString(r.getRoomType(), "RoomWBath");
        Assert.assertNotEqualsString(r.getReservationStartDate(), "Jul 01, 2022");
        Assert.assertNotEqualsString(r.getReservationEndDate(), "Jul 05, 2022");  // Fails as it equals to Jul 05 2022
        Assert.assertNotEqualsString(r6.getReservationStartDate(), "Feb 28, 2024");
        Assert.assertNotEqualsString(r6.getReservationEndDate(), "Mar 01, 2024");  // Fails as it equals to Mar 01 2024
    }

    /**
     * This method/function tests out CalculateReservationNumberOfDays for users' reservation at JJ's B&B.
     * It should incorporate black-box testing techniques and other checks.
     */
    public static void testCalculateReservationNumberOfDays() throws Exception {
        System.out.println();
        System.out.println("Testing CalculateReservationNumberOfDays");
        System.out.println("----------------------------------------");
        // Equivalence Partitioning Test Cases
        Reservation r = new Reservation(1, "NormalRoom", "Jan 02, 2025", "Jan 05, 2025");
        long numberOfDays = r.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays, 3);
        
        Reservation r2 = new Reservation(2, "RoomWBath", "Mar 01, 2025", "Mar 05, 2025");
        long numberOfDays2 = r2.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays2, 4);

        Reservation r3 = new Reservation(3, "RoomWView", "Apr 15, 2025", "Apr 20, 2025");
        long numberOfDays3 = r3.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays3, 5);
        
        System.out.println();
        System.out.println("Testing Boundary Cases for CalculateReservationNumberOfDays");
        System.out.println("-------------------------------");
        // Boundary Value Analysis Test Cases
        Reservation r4 = new Reservation(4, "RoomWBath", "Feb 28, 2024", "Mar 01, 2024"); // Leap Year
        long numberOfDays4 = r4.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays4, 2);

        Reservation r5 = new Reservation(5, "NormalRoom", "Dec 31, 2024", "Jan 01, 2025"); // Year Boundary
        long numberOfDays5 = r5.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays5, 1);

        Reservation r6 = new Reservation(6, "RoomWView", "Jan 01, 2025", "Jan 02, 2025");
        long numberOfDays6 = r6.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays6, 1);

        Reservation r7 = new Reservation(7, "RoomWView", "Jan 01, 2025", "Jan 01, 2025"); // Same Start and End Date
        long numberOfDays7 = r7.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays7, 0);

        Reservation r8 = new Reservation(8, "NormalRoom", "Feb 28, 2021", "Mar 01, 2021"); // Non-Leap Year
        long numberOfDays8 = r8.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays8, 1);

        Reservation r9 = new Reservation(9, "RoomWView", "Feb 29, 2020", "Mar 01, 2020"); // Leap Day on Leap Year
        long numberOfDays9 = r9.calculateReversationNumberOfDays();
        Assert.assertEqualsInt((int) numberOfDays9, 1);
        
        System.out.println();
        System.out.println("Testing Extra Not Equals and Equals");
        System.out.println("-------------------------------");
        // Testing out if it will throw an exception if inputed invalid dates when changed or updated.
        // It should test even if error will i calculate as well.
        Reservation r10 = new Reservation(10, "RoomWView", "Feb 29, 2020", "Mar 01, 2020"); // Leap Day on Leap Year
        r10.setRoom("RoomWBath");
        r10.setReservationStartDate("Dec 1, 2024");
        r10.setReservationEndDate("Jan 01, 2022");
        long numberOfDays10 = r10.calculateReversationNumberOfDays();
        // This tells me that the code has bee incorrectly counting the days.
        // This is because the actual 672 is not 0 but a starting date cannot be in the future of the end date (start must be before end).
        Assert.assertEqualsInt((int) numberOfDays10, 0);
        //Testing negative values and some floats in the days to throw exceptions.
        Assert.assertEqualsInt((int) numberOfDays9, 1);
        Assert.assertEqualsInt((int) numberOfDays9, -1);
        Assert.assertNotEqualsInt((int) numberOfDays9, -1);
        Assert.assertNotEqualsDouble(numberOfDays9, 1.1);
        Assert.assertEqualsDouble(numberOfDays9, 1.0);
        // Test invalid input of day, negative day number
        Reservation r11 = new Reservation(-10, "RoomWView", "Feb 29, 2023", "Mar 01, 2023");
        long numberOfDays11 = r11.calculateReversationNumberOfDays();
        Assert.assertNotEqualsInt((int) numberOfDays11, -1);
        Assert.assertEqualsInt(r11.getGuestID(), -10);
    }

    /**
     * This method/function tests out CalculateReservationBillAmount for users' reservation at JJ's B&B.
     * It should incorporate black-box testing techniques and other checks.
     */
    public static void testCalculateReservationBillAmount() throws Exception {
        System.out.println();
        System.out.println("Testing calculateReservationBillAmount");
        System.out.println("--------------------------------------");
        // Equivalence Partitioning Test Cases

        // Test case for RoomWBath with many days
        Reservation r1 = new Reservation(1, "RoomWBath", "Jan 03, 2025", "Jan 06, 2025");
        double billAmount1 = r1.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount1, 600.0);  // 3 days * $200 = $600
        Assert.assertNotEqualsDouble(billAmount1, 600.0);
        
        // 1 day with RoomWBath
        Reservation r4 = new Reservation(1, "RoomWBath", "Jan 01, 2025", "Jan 02, 2025");
        double billAmount4 = r4.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount4, 200);  // 1 day * $200 = $200
        Assert.assertNotEqualsDouble(billAmount4, 200);

        // Test case for RoomWView
        Reservation r2 = new Reservation(2, "RoomWView", "Feb 01, 2025", "Feb 04, 2025");
        double billAmount2 = r2.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount2, 525);  // 3 days * $175 = $525
        Assert.assertNotEqualsDouble(billAmount2, 525);
        
        // 1 day with RoomWView
        Reservation r5 = new Reservation(1, "RoomWView", "Feb 01, 2025", "Feb 02, 2025");
        double billAmount5 = r5.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount5, 175);  // 1 day * $175 = $175
        Assert.assertNotEqualsDouble(billAmount5, 175);

        // Test case for NormalRoom
        Reservation r3 = new Reservation(3, "NormalRoom", "Mar 01, 2025", "Mar 05, 2025");
        double billAmount3 = r3.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount3, 500);  // 4 days * $125 = $500
        Assert.assertNotEqualsDouble(billAmount3, 500);
        
        // 1 day with NormalRoom
        Reservation r6 = new Reservation(6, "NormalRoom", "Mar 01, 2025", "Mar 02, 2025");
        double billAmount6 = r6.calculateReservationBillAmount();
        Assert.assertEqualsDouble(billAmount6, 125);  // 1 day * $125 = $125
        Assert.assertNotEqualsDouble(billAmount6, 125);
    }

}
