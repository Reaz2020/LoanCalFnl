
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

    /*@Test
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

    }*/

    @Test
    void printCustomers() {
        String printLine1="****************************************************************************************************";
        String printLine3="****************************************************************************************************";
        ArrayList<String> tempList = new ArrayList<>();
        //test customer with surname created and added to the temp list
        int  prospect = 1;
        String firstName= "Simon";
        String lastName="And";
        String amount="1000",interest="1",year="4";
        tempList.add(0,firstName);
        tempList.add(1,lastName);
        String fullName=tempList.get(0)+tempList.get(1);
        tempList.add(2,amount);
        tempList.add(3,interest);
        tempList.add(4,year);
        //next four lines are created for testing purpose, I'll calculate the pay back amount and compare if methods returns the same amount.
        double amount2= Double.parseDouble(amount);
        double interest2= Double.parseDouble(interest);
        int year2= Integer.parseInt(year);
        //double monthlyPay=fileHandling.calculateMonthlyPayment(amount2,interest2,year2);//fixedMonthlyPayment
        double monthlyPay=fileHandling.fixedMonthlyPayment(amount2,interest2,year2);
       // tempList.add(5,monthlyPay);

        //saving the method return in a string to compare easily in the assert method
        String retrunedValue=fileHandling.printCustomers(tempList,prospect);
        //printing customer if has surname
        String printLine2="Prospect : "+prospect+" "+firstName+lastName+ " wants to borrow " + amount2 +" € "+ "  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";
        //if customer had a surname ,
        String printLine2_ForCustomerWithOnlyFirstName="Prospect : "+prospect+" "+firstName+ " wants to borrow " + amount2 +" € "+ "  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";

        //tested if customer has a surname
        assertEquals(printLine1+"\n"+printLine2+"\n"+printLine3,retrunedValue);
        //customer has a surname so this assert Not true
        assertNotEquals(printLine1+"\n"+printLine2_ForCustomerWithOnlyFirstName+printLine3,retrunedValue);

    }


    @Test
    void printCustomers2() {
        String printLine1 = "****************************************************************************************************";
        String printLine3 = "****************************************************************************************************";

        //another mock customer making and adding in the tempList2 for testing customer who does not have a surname
        ArrayList<String> tempList2 = new ArrayList<>();
        //test customer with surname created and added to the temp list
        int prospect2 = 2;
        String firstName2 = "SimonTwo", amount3 = "2000", interest3 = "1.5", year3 = "4";
        tempList2.add(0, firstName2);
        tempList2.add(1, amount3);
        tempList2.add(2, interest3);
        tempList2.add(3, year3);
        //added a manually because devideString method add A autometically after each array List
        tempList2.add(4,"A");
        //next four lines are created for testing purpose, I'll calculate the pay back amount and compare if methods returns the same amount.
        double amount4 = Double.parseDouble(amount3);
        double interest4 = Double.parseDouble(interest3);
        int year4 = Integer.parseInt(year3);
       // double monthlyPay2 = fileHandling.calculateMonthlyPayment(amount4, interest4, year4);
        double monthlyPay2 = fileHandling.fixedMonthlyPayment(amount4, interest4, year4);
        //saving the method return in a string to compare easily in the assert method
        String retrunedValue2=fileHandling.printCustomers(tempList2,prospect2);
        String printLine2_forCustomerWithOnlyFirstName = "Prospect : " + prospect2 + " " + firstName2 + " wants to borrow " + amount4 + " € " + "  for a period of " + year4 + " and pay " + monthlyPay2 + " € " + " each month ";
        assertEquals(printLine1+"\n"+printLine2_forCustomerWithOnlyFirstName+"\n"+printLine3,retrunedValue2);
    }

    @Test
    void power(){
        assertEquals(27,fileHandling.power(3,3));
        assertNotEquals(26,fileHandling.power(3,3));

    }
    @Test
    void fixedMonthlyPayment(){
        assertEquals(2124.704471126838,fileHandling.fixedMonthlyPayment(100000,10,5));
        //test has been performed using boundary value
        assertNotEquals(2124.704471126848,fileHandling.fixedMonthlyPayment(100000,10,5));

    }




    FileHandlingTest() throws FileNotFoundException {
    }
}