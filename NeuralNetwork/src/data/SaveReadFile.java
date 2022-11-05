package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class SaveReadFile {
	
	public static void saveToFile(ArrayList<Integer> input, String filename) {
		PrintWriter pw = null;
        try {
            File file = new File("C:\\Users\\Adam\\git\\SieciNeuronowe\\resources\\" + filename + ".txt");// probowa³em inaczej ale albo nie mo¿e znalezæ okreœlonej 
            																							  // œcie¿ki albo odmowa dostêpu	 
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
	
	 public static ArrayList<DaneTreningowe> readTrainingSets() {
	        ArrayList<DaneTreningowe> daneTreningowe = new ArrayList<>();

	        for (int i = 0; i < 26; i++) {
	            char letterValue = (char) (i + 65);
	            String letter = String.valueOf(letterValue);
	            for (ArrayList<Integer> list : readFromFile("C:\\Users\\Adam\\git\\SieciNeuronowe\\resources\\" + letter + ".txt")) {
	                daneTreningowe.add(new DaneTreningowe(list));
	            }
	        }

	        return daneTreningowe;
	    }
	
	 private static ArrayList<ArrayList<Integer>> readFromFile(String filename) {
	        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

	        try {
	            InputStream in = SaveReadFile.class.getClass().getResourceAsStream(filename);
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                ArrayList<Integer> input = new ArrayList<>();
	                for (int i = 0; i < line.length(); i++) {
	                    int value = 0;
	                    try {
	                        value = Integer.parseInt(String.valueOf(line.charAt(i)));
	                    } catch (Exception e) {
	                    }
	                    input.add(value);
	                }
	                inputs.add(input);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return inputs;
	    }

}
