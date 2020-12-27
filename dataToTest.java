import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FilenameFilter;

public class dataToTest {
    
    String urlBase = "/Users/gustavberloty/Documents/GitHub/comparingCNTRdata/";
    
    public dataToTest() {
        
        String url = urlBase + "Data/dataToTest/";
        String newFolderName = "\"`date +%Y-%m-%d` - not (yet) fully downloaded\"";

		/*
		
			YOUR CODE HERE.
		
		*/

        try {
			  FileWriter myWriter = new FileWriter(".downloadDataToCompare");
			  File file = new File(urlBase + "Data/dataToTest/");
			  
			  String[] directories = file.list(new FilenameFilter() {
				@Override
				public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
				}
			  });
			  
			  String aCommand = "cd " + url + "\n";
			  myWriter.write("\n" + aCommand);
			  
			  for(int i=0; i < 11; i++) {
			  	myWriter.write(command[i]);
			  }
			  if (directories.length > 0) {
				  aCommand = "\nzip -rm \"" + directories[0] + " (zipped ";
				  aCommand += "automatically just before the `date +%Y-%m-%d` ";
				  aCommand +=  "folder was ready).zip\" " + directories[0] + "\n";
				  myWriter.write(aCommand);
			  }
			  
			  aCommand = "mv " + newFolderName + " ";
			  aCommand += "`date +%Y-%m-%d`\n\n";
			  myWriter.write(aCommand);
			  
			  myWriter.close();
			  // System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			  System.out.println("An error occurred when we tried to write the file.");
			  e.printStackTrace();
		}    
    }
    
    public static void main(String[] args) {
    
    	try {
    	// The UpdateData binary is normally executed from the binary folder.
		  File myObj = new File(".downloadDataToCompare");
		  if (myObj.createNewFile()) {
        	// System.out.println("File created: " + myObj.getName());
          } else {
        	System.out.println("File already exists.");
          }
    	} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	new dataToTest();
    }
}
    
