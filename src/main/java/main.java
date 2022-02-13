import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws FileNotFoundException  {

        //each time project opened from the file, file path need to be changed
        FileReader fileReader = new FileReader("C:\\Users\\sumay\\OneDrive\\Desktop\\LoanCalFnl\\src\\main\\java\\prospects.txt");
        FileHandling fileOne = new FileHandling();
        // fileHandling method takes in fileReader, remove leading and trailing whitespace & don't write out blank lines & returns a new list
        ArrayList<String> a = fileOne.fileHandling(fileReader);
        // Removes header lines (first line) & lines contains dots only
        fileOne.removingUnneccesarryThingsFromLins(a);
        //file will be takes care from index 1, since first line is removed
        int prospect=0;
        ArrayList<String> b;
        for (int i=1;i <a.size();i++)
        {
            prospect++;
            b = fileOne.devideString(a.get(i));
            //String print2=fileOne.printCustomerOnlyFirstName(b,prospect);
            String print=fileOne.printCustomers(b,prospect);
            System.out.println(print);
        }
        //____________________________________
        System.out.println("for testing ");

        System.out.println("for testing index 1 in array list  "+ a.get(1)  );
    }
}
