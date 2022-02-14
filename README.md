# LoanCalFnl
-->prospect.txt is the file which is taken input using a file reader in the main class. 
-->class FileHandling implemented all the methods 
-->class main was only used to call the methods  from the class FileHandLing using an object of that class
-->fileForTest.txt is another file which is only used for JUnit testing and this file was only taken input in the test class (FileHandlingTest class)


methods in FileHandling class 
#fileHandling(FileReader fr)
 It has taken the file , removed leading and trailing whitespace  and did not add empty lines , and returned a list 
 
#removingUnneccesarryThingsFromLins ( ArrayList<String>  fileContent)
  It has taken into a List of lines as a parameter  and removed header line , and all the lines that contain dots only "." and returned a new list containing lines 
  
#ArrayList<String> devideString(String client)
  From the previous list , each line (as string) was sent to this method as parameter, it cleaned all the extra things like ("Anna Haman",12,2--->Anna Haman 12 2) quatation marks   and splited the lines where "," was found and saved them into an arrayList and returned a list with each element (like firstName,surName,Interest,year) seperatly.(this method     was called from main using a loop because in each loop each lines was sent as string )
  
#printCustomers(ArrayList<String> cl, int prospect).
  this method taken in that arrayLis retuned by previous method and printed them , it has also called next method 
  calculateMonthlyPayment(double amnt , double intrestRate,int year) to calculate the amount customer will pay each month
  
  
#calculateMonthlyPayment(double amnt , double intrestRate,int year)

 
 *each time main class is run, prospect.txt files absolute path need to update
 *each time tests run, file path for fileForTest.txt file in class  FileHandlingTest need to update
 *Maven builts tool has been used (I think I did not update latest version of maven I had old one in my pc but it is in pom.xml)
 * New method added for calculating monthly return .... according to code tests morgatge calculation formate, old format also there but not been called 
 
 

 
  

