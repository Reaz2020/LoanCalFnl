

import java.io.*;;
import java.util.*;

public class FileHandling {
    ArrayList<String> fileHandling(FileReader fr){
        ArrayList<String> fileContent = new ArrayList<String>();

           BufferedReader br = new BufferedReader(fr);
           String line = null;

           while(true)
           {
               try {
                   if (!((line = br.readLine()) != null)) break;
               } catch (IOException e) {
                   e.printStackTrace();
               }

               line = line.trim(); // remove leading and trailing whitespace

               if (!line.equals("")) // don't write out blank lines
               {
                   fileContent.add(line);
               }
           }
           return fileContent;
    }
    ArrayList<String> removingUnneccesarryThingsFromLins ( ArrayList<String>  fileContent){

        String newString = "";

        for (int i=1;i <fileContent.size();i++) {
            fileContent.remove(".");
        }
        // Removes Original Line
        fileContent.remove(0);
        // Enters New Line
        fileContent.add(0, newString);
        // Writes the new content to file

return fileContent;

    }
    ArrayList<String> devideString(String client) {
        ArrayList<String> cl = new ArrayList<String>();
        Scanner sc = new Scanner(client);
        String[] personalInfo = sc.nextLine().split(" ");
        for (int i = 0; i < personalInfo.length; i++) {
        }
        String[] personalInfo2;
        for (int p = 0; p < personalInfo.length; p++) {
            String s = personalInfo[p];
            Scanner sc2 = new Scanner(s);
            personalInfo2 = sc2.nextLine().split("\\,");

            for (int q = 0; q < personalInfo2.length; q++) {
                String str = personalInfo2[q].replaceAll("\"", "");
                cl.add(str);
            }
        }cl.add("A");

   return cl; }
    public double calculateMonthlyPayment(double amnt , double intrestRate,int year){

        if(amnt>0.0&&year>0){
            double monthlyReturn;
            double totalInterest=(amnt*intrestRate)/100;
            double yearlyReturn=(totalInterest+amnt)/year;
            monthlyReturn=yearlyReturn/12;
            return monthlyReturn;
        }
        if (intrestRate>-1&&amnt>0.0&&year>0){
            int totalMonths=year*12;
            double mnthReturn=amnt/totalMonths;
            return mnthReturn;
        }
        if(amnt==0.0&&year==0){return 0.0;}
        else return 0.0;


    }
    public String printCustomers(ArrayList<String> cl, int prospect){
        String firstName=null,lastName=null;
        double amount = 0, interest = 0;
        int year = 0;
        double monthlyPay= 0;
        String printLine1="****************************************************************************************************";
        String printLine2;
        String printLine2forSeconed;
        String printLine3="****************************************************************************************************";

        if (cl.get(4)!="A"){
            firstName= cl.get(0);
            lastName=(cl.get(1));
            amount = Double.parseDouble(cl.get(2));
            interest = Double.parseDouble(cl.get(3));
            year = (int) Double.parseDouble(cl.get(4));
            monthlyPay= calculateMonthlyPayment(amount,interest,year);
            printLine2="Prospect : "+prospect+" "+firstName+lastName+ " wants to borrow " + amount +" € "+ "  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";
            System.out.println();
            /*System.out.println(printLine1);
            System.out.println(printLine2);
            System.out.println(printLine3);*/
            String ret=printLine1+"\n"+
                    printLine2+"\n"+
                    printLine3;
            return ret;

         }

        else
            firstName = cl.get(0);
            amount = Double.parseDouble(cl.get(1));
            interest = Double.parseDouble(cl.get(2));
            year = (int) Double.parseDouble(cl.get(3));
            monthlyPay= calculateMonthlyPayment(amount,interest,year);

            System.out.println();
            printLine2forSeconed="Prospect : "+prospect+" "+firstName+ " wants to borrow " + amount + " € "+"  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";
            String ret2=printLine1+"\n"+printLine2forSeconed+"\n"+printLine3;
            return  ret2;}
    /*public void printCustomerOnlyFirstName(   ArrayList<String> cl, int prospect){
        String firstName;
        double amount = 0, interest = 0;
        int year = 0;
        double monthlyPay= 0;
        if (cl.get(4)=="A")
        {    firstName = cl.get(0);
            amount = Double.parseDouble(cl.get(1));
            interest = Double.parseDouble(cl.get(2));
            year = (int) Double.parseDouble(cl.get(3));
            monthlyPay= calculateMonthlyPayment(amount,interest,year);

            System.out.println();

            System.out.println("****************************************************************************************************");
            System.out.println("Prospect : "+prospect+" "+firstName+ " wants to borrow " + amount + " € "+"  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ");
            System.out.println("****************************************************************************************************");

        }

    }*/




}











