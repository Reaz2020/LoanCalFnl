# LoanCalFnl
prospect.txt is the file which is taken input using a file reader in the main class. 
class FileHandling implemented all the methods 
main class was only used to call the methods  from the class FileHandLing using an object od that class
fileForTest.txt is another file which is only used for J Unit testing and this file was only taken input in the test class (FileHandlingTest class)

methods in FileHandling class 
#fileHandling(FileReader fr)
 It has taken the file , removed leading and trailing whitespace  and did not add empty lines , and returned a list 
 
#removingUnneccesarryThingsFromLins ( ArrayList<String>  fileContent)
  It has taken into List as a parameter and and removed header line , and all the lines that contain dots only "." and returned a new list containing lines 
  
#ArrayList<String> devideString(String client)
  From the previous list , each line (as string) was sent to this method as parameter, it cleaned all the extra things like ("Anna Haman",12,2--->Anna Haman 12 2) quatation marks   and splited the lines where "," was found and saved them into an arrayList and returned a list with each element (like firstName,surName,Interest,year) seperatly.
  
#printCustomers(ArrayList<String> cl, int prospect).
  this method taken in that arrayLis retuned by previous method and printed them , it has also called next method 
  calculateMonthlyPayment(double amnt , double intrestRate,int year) to calculate the amount customer will pay each month
  
  
#calculateMonthlyPayment(double amnt , double intrestRate,int year)
  

