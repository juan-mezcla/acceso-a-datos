package Tarea4;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt=new Scanner(System.in);
		
		String nombreArch=prompt.nextLine();
		
		String rutaArch=prompt.nextLine()+nombreArch+".txt";
		
		
		try {
			FileOutputStream escrituraArch=new FileOutputStream(new File(rutaArch),true);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			escrituraArch.close();
		}
		
	}

}
