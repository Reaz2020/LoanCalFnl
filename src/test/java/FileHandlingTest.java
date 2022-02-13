
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlingTest  {
    FileHandling fileHandling=new FileHandling();
    FileReader fileReader=new FileReader("C:\\Users\\sumay\\OneDrive\\Desktop\\LoanCalFnl\\src\\test\\java\\fileForTest.txt");


    @Test
    void fileHandling() {
        ArrayList expectedList=fileHandling.fileHandling(fileReader);
        ArrayList actualList= new ArrayList();
        actualList.add(0,"Customer,Total loan,Interest,Years");
        actualList.add(1,"Juha,1000,5,2");
        actualList.add(2,"Karvinen,4356,1.27,6");
        actualList.add(3,"Claes Månsson,1300.55,8.67,2");
        actualList.add(4,"\"Clarencé,Andersson\",2000,6,4");
        actualList.add(5,"anna,500,2.5,3");
        actualList.add(6,".");
        //1. Test equal.
        assertEquals(actualList.get(0),expectedList.get(0));
        assertEquals(actualList.get(1),expectedList.get(1));
        assertEquals(actualList.get(2),expectedList.get(2));
        assertEquals(actualList.get(3),expectedList.get(3));
        assertEquals(actualList.get(4),expectedList.get(4));
        assertEquals(actualList.get(5),expectedList.get(5));
        assertEquals(actualList.get(4),expectedList.get(4));
        assertNotEquals(actualList.get(4),expectedList.get(5));
        assertEquals(actualList.size(),expectedList.size());
        assertEquals(7,expectedList.size());

    }

    @Test
    void removingUnneccesarryThingsFromLins() {
        ArrayList tempList=new ArrayList();
        tempList.add(0,"first line");
        tempList.add(1,"abcd");
        tempList.add(2,".");
        tempList.add(3,"cdef");
        tempList.add(4,"efgh");
        tempList.add(5,"moved from index 5");
        ArrayList returnedList=fileHandling.removingUnneccesarryThingsFromLins(tempList);
        fileHandling.removingUnneccesarryThingsFromLins(tempList);
        assertEquals("",returnedList.get(0));
        assertEquals("abcd",returnedList.get(1));
        //index 2 has been removed () and 3 has moved to 2
        assertNotEquals(".",returnedList.get(2));
        assertEquals("cdef",returnedList.get(2));
        assertEquals("efgh",returnedList.get(3));
        assertEquals("moved from index 5",returnedList.get(4));


    }

    @Test
    void devideString() {
        //only names and amount and years are saved into a new array
        ArrayList tempList=new ArrayList();
        ArrayList returnedList=fileHandling.devideString("\"Claes Månsson,1000");
        assertNotEquals("\"",returnedList.get(0));
        assertEquals("Claes",returnedList.get(0));
        assertEquals("Månsson",returnedList.get(1));
        assertEquals("1000",returnedList.get(2));


    }

    @Test
    void calculateMonthlyPayment() {
        double amount = fileHandling.calculateMonthlyPayment(2000.0,6,4);
        double amount2 = fileHandling.calculateMonthlyPayment(0.0,0,1);
        double amount3 = fileHandling.calculateMonthlyPayment(0.0,1,0);
        double amount4 = fileHandling.calculateMonthlyPayment(1.0,0,0);
        double amount5 = fileHandling.calculateMonthlyPayment(0.0,1,1);
        //if interest rate is 0.0 but amount and year exists , we assume interest rate is 0
        double amount6 = fileHandling.calculateMonthlyPayment(72.0,0,1);
        double amount7 = fileHandling.calculateMonthlyPayment(-1,0,0);
        double amount8 = fileHandling.calculateMonthlyPayment(0,-1,0);
        double amount9 = fileHandling.calculateMonthlyPayment(0,0,-1);
        double amount10 = fileHandling.calculateMonthlyPayment(-1,-1,-1);
        assertEquals(44.166666666666664,amount);
        //boundary value checking
        assertNotEquals(44.166666666666674,amount);
        assertEquals(0.0,amount2,"amount and/or year  filed is empty");
        assertEquals(0.0,amount3,"amount and/or year  filed is empty");
        assertEquals(0.0,amount4,"amount and/or year  filed is empty");
        assertEquals(0.0,amount5,"amount and/or year  filed is empty");
        //if interest rate is 0.0 but amount and year exists , we assume interest rate is 0
        assertEquals(6.0,amount6,"interest rate 0");
        assertEquals(0.0,amount7,"loan amount -1 ");
        assertEquals(0.0,amount8,"interest amount -1 ");
        assertEquals(0.0,amount9,"year amount -1 ");
        assertEquals(0.0,amount10,"values -1 ");

    }

    @Test
    void printCustomerWithSurname() {
        String printLine1="****************************************************************************************************";
        String printLine3="****************************************************************************************************";
        ArrayList<String> tempList = new ArrayList<>();
        //FileHandling fileHandling1 = mock(FileHandling.class);
        int  prospect = 1;
        String firstName= "Simon";
        String lastName="And";
        String amount="1000",interest="1",monthlyPay="2",year="4";
       // ArrayList<String> tempList;
        tempList.add(0,firstName);
        tempList.add(1,lastName);
        String fullName=tempList.get(0)+tempList.get(1);
        tempList.add(2,amount);
        tempList.add(3,interest);
        tempList.add(4,year);
        //nest four line was created for testing purpose, I'll calculate the pay back amount and compare if methods returns the same amount.
        double amount2= Double.parseDouble(amount);
        double interest2= Double.parseDouble(interest);
        int year2= Integer.parseInt(year);
        double monthlyPay2=fileHandling.calculateMonthlyPayment(amount2,interest2,year2);
        tempList.add(5,monthlyPay);
        String retrunedValue=fileHandling.printCustomers(tempList,prospect);
        String printLine2="Prospect : "+prospect+" "+firstName+lastName+ " wants to borrow " + amount2 +" € "+ "  for a period of " + year + " and pay " +monthlyPay2+ " € "+" each month ";

        assertEquals(printLine1+"\n"+printLine2+"\n"+printLine3,retrunedValue);

    }




    FileHandlingTest() throws FileNotFoundException {
    }
}