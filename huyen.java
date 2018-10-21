import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class huyen {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println("ꯀ:<s=\u0126");
		File[] hello = finder(System.getProperty("user.dir"));
		Boolean iffiles=false;
		for (File file : hello) {
			iffiles=true;
			System.out.print("directory:");
			if (file.isDirectory()) {
				System.out.print("directory:");
			} else {
				System.out.print("file:");
			}
			try {
				String curdir = file.getCanonicalPath();
				System.out.println(curdir);
				String readedtxt = readFile(curdir);
//					iyekthis(readedtxt);
//					System.out.println(iyekthis(readedtxt));

				// TODO Extract the file name from the directory
				File f = new File(curdir);
				String myDir = f.getParent();
				String curfile = f.getName();
//					System.out.println(curfile);

				// TODO Create a directory"output"
//					System.out.println(myDir);
				new File(myDir + "\\" + "output").mkdirs();
//					System.out.println(myDir);

				// TODO Write the "readtext"

				Writer(myDir + "\\" + "output\\" + curfile, iyekthis(readedtxt));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(!iffiles) {System.out.print("No accessible files found");}

	}

	////////////////////////////////////////
	///////////// Functions //////////
	////////////////////////////////////////
	private static File[] finder(String dirName) {//Function to List all the .ytxt files
		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith(".txt");
			}
		});

	}

	private static String readFile(String fileName) throws IOException {//Function to read File
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	 private static  String iyekthis(String arg){
	    
//		    arg="ag\\kAx";      
	        arg=arg+"*####*Dictionary﴿s﴾ꯀ﴿K﴾ꯁ﴿m﴾ꯂ﴿a﴾ꯃ﴿w﴾ꯄ﴿e﴾ꯅ﴿v﴾ꯆ﴿f﴾ꯇ﴿Z﴾ꯉ﴿F﴾ꯊ﴿_﴾ꯋ﴿\\﴾ꯌ﴿o﴾ꯍ﴿B﴾ꯎ﴿T﴾ꯏ﴿W﴾ꯐ﴿x﴾ꯒ﴿j﴾ꯔ﴿q﴾ꯕ﴿r﴾ꯗ﴿d﴾ꯛ﴿M﴾ꯜ﴿A﴾ꯝ﴿N﴾ꯞ﴿E﴾ꯟ﴿G﴾ꯠ﴿i﴾ꯡ﴿O﴾ꯣ﴿g﴾ꯤ﴿k﴾ꯥ﴿l﴾ꯦ﴿y﴾ꯧ﴿b﴾ꯨ﴿p﴾ꯩ﴿﴾ꯪ﴿1﴾꯱﴿2﴾꯲﴿3﴾꯳﴿4﴾꯴﴿5﴾꯵﴿6﴾꯶﴿7﴾꯷﴿8﴾꯸﴿9﴾꯹﴿0﴾꯰﴿!﴾꯫﴿[﴾ꯑ﴿S﴾ꯈ﴿z﴾ꯚ﴿D﴾꯭﴿c﴾ꯖ﴿I﴾ꯪ﴿?﴾꫱﴿,﴾꫰﴿C﴾ꯓ﴿X﴾ꯘ﴿R﴾ꯙ﴿";
	        arg=arg.replaceAll("(?s)(.)(?=.*﴿\\1﴾(.*?)﴿)","$2");                                                 //here leter like "ch","dh","bh" are converted to single letter like ç,ð,v and so on
	       String[] seperate=arg.split("\\*####\\*");                                                                         //here the *####*Dictio........... is remove
	        arg=seperate[0];                                                                                                        // upto here input word "KYaamgei hairiba maphamsi" to "ãk-꯭ꯌâmgã håꯔiba mafamsi" [no change because the above two line is for handlng "r" in different words]
//	       System.out.println(arg);
	        return arg;
	       

	    }

	private static void Writer(String filepath, String text) {//Function to write file

//	        try {
//	        	System.out.println("Writting.....");
//	        	PrintWriter writer = new PrintWriter(filepath, "UTF-8");
//	            writer.println(text);
//	            writer.close();
//	        } catch (Exception e) {
//	        	System.out.println("Cannot Write The text file");
//	            e.printStackTrace();
//	        } 
//	        }

		BufferedWriter writer = null;
		try {
			// create a temporary file
			File logFile = new File(filepath);
			text = text.replaceAll("\n", "\r\n");
//        	System.out.println(text);
			// This will output the full path where the file will be written to...
//			writer = new BufferedWriter(new FileWriter(logFile));
			writer = new BufferedWriter
				    (new OutputStreamWriter(new FileOutputStream(logFile), StandardCharsets.UTF_8));//it help to use UTF-8 fonts like Meetei mayek
			writer.write(text);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}

	}
}
