

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
        String firstName=null;
        String lastName=null;
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
            //monthlyPay= calculateMonthlyPayment(amount,interest,year);
            monthlyPay=fixedMonthlyPayment(amount,interest,year);
            printLine2="Prospect : "+prospect+" "+firstName+lastName+ " wants to borrow " + amount +" € "+ "  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";
            System.out.println();
            String ret=printLine1+"\n"+ printLine2+"\n"+ printLine3;
            return ret;

         }

        if (cl.get(4)=="A")
            firstName = cl.get(0);
            amount = Double.parseDouble(cl.get(1));
            interest = Double.parseDouble(cl.get(2));
            year = (int) Double.parseDouble(cl.get(3));
            //monthlyPay= calculateMonthlyPayment(amount,interest,year);
             monthlyPay=fixedMonthlyPayment(amount,interest,year);
            System.out.println();
            printLine2forSeconed="Prospect : "+prospect+" "+firstName+ " wants to borrow " + amount + " € "+"  for a period of " + year + " and pay " +monthlyPay+ " € "+" each month ";
            String ret2=printLine1+"\n"+printLine2forSeconed+"\n"+printLine3;
            return  ret2;


    }

    // this two method I have added to calculate fixed monthly repayment according to the morgatge calculator formate given in the code test
    // without using math class of java but they have not been used here J unit tests have been performom on them
    public  double power(double x, int y) {
        double temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);

        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
    public  double fixedMonthlyPayment(double totalLoan_U, double interestOnAYearlyBasis_B, int year) {
        double interestOnAMonthlyBasis_b= (interestOnAYearlyBasis_B/100)/12.0;
        int numberOfPayMent_P = year * 12;
        double fixedMonthlyPayment = 0;
        double InterestOnMonthlyBasisPLUSone = 1 + interestOnAMonthlyBasis_b; //(1 + b)
        double InterestOnMonthlyBasisPlusOne_toThePower_numberOfPayment = power(InterestOnMonthlyBasisPLUSone, numberOfPayMent_P); // (1 + b)^p]
        fixedMonthlyPayment = totalLoan_U * (interestOnAMonthlyBasis_b * (InterestOnMonthlyBasisPlusOne_toThePower_numberOfPayment) / (InterestOnMonthlyBasisPlusOne_toThePower_numberOfPayment - 1));
        return fixedMonthlyPayment;
    }






}











