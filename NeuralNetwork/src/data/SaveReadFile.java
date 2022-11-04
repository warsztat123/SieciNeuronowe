package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveReadFile {
	
	public static void saveToFile(ArrayList<Integer> input, String filename) {
		PrintWriter pw = null;
        try {
            File file = new File("C:\\Users\\Adam\\git\\SieciNeuronowe\\resources\\" + filename + ".txt");// probowa�em inaczej ale albo nie mo�e znalez� okre�lonej 
            																							  // �cie�ki albo odmowa dost�pu	 
            pw = new PrintWriter(new FileOutputStream(file, true));
            for (Integer i : input) {
                pw.write(Integer.toString(i));
            }
            pw.write("\n");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
        	if (pw != null) {
                pw.close();
            }
        }
    }

}
