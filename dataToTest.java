import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FilenameFilter;

public class dataToTest {
    
    String urlBase = "/Users/gustavberloty/Documents/GitHub/comparingCNTRdata/";
    
    public dataToTest() {
    
    	String[] command = new String[11];
        for (int i = 0; i < command.length; i++) {
            command[i] = "";
        }
        
        String url = urlBase + "Data/dataToTest/";
        String newFolderName = "\"`date +%Y-%m-%d` - not (yet) fully downloaded\"";
        command[0] += "mkdir " + newFolderName + "\n\n";
		
		String websiteBase = "https://verite.github.io/bible-grec-interligne/bcgr/"; // forme : livre-chapitre.html
		
		for (int book = 40; book <= 66; book++) {
            switch (book) {
                case 40 : case 44 :
                    command[0] += "for i in {1..9}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\nfor i in {10..28}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 41 : case 45 : case 46 :
                    command[1] += "for i in {1..9}; do curl" + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\nfor i in {10..16}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 42 :
                    command[2] += "for i in {1..9}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html;done;\nfor i in {10..24}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 43 :
                    command[3] += "for i in {1..9}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\nfor i in {10..21}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 47 : case 58 :
                    command[4] += "for i in {1..9}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\nfor i in {10..13}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 48 : case 49 : case 54 :
                    command[5] += "for i in {1..6}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 50 : case 51 : case 55 :
                    command[6] += "for i in {1..4}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 52 : case 59 : case 60 : case 62 :
                    command[7] += "for i in {1..5}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 53 : case 56 : case 61 :
                    command[8] += "for i in {1..3}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
                case 57 : case 63 : case 64 : case 65 :
                    command[9] += "curl " + websiteBase + (book - 39) + "001.html >" + url + newFolderName + "/" + (book - 39) + "001.html;\n";
                break;
                case 66 :
                    command[10] += "for i in {1..9}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\nfor i in {10..22}; do curl " + websiteBase + (book - 39) + "-${i}.html >" + url + newFolderName + "/" + (book - 39) + "-${i}.html; done;\n";
                break;
            }
        }


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
    
