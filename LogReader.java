package assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class LogReader {

	public static void main(String[] args) {
		try {
			//input file
			FileInputStream fstream = new FileInputStream("input.log");
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//output file
			BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
			
			String strLine;
			boolean broken = false;
			int line = 0;
			
			while ((strLine = br.readLine()) != null) {
				
				if (strLine.contains("NullPointerException")) {
					broken = true;
				}
				//write next lines after exception
				if (broken) {
					out.write(strLine);
					out.newLine();
					line++;
				}
				if (line == 10) {      
					broken = false;
					line = 0;
				}
			}
			in.close();
			out.close();
			System.out.println("Successfully written to file");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
