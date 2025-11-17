package tarea10b;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archJson = new File("alumnos.json");

		try {
			if (!archJson.exists()) {
				archJson.createNewFile();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			FileWriter escribirJson = new FileWriter(archJson);
			for(int i=0; i<5; i++) {
				
				gson.toJson(new Alumno(), escribirJson);
			}
			 System.out.println("Archivo JSON creado correctamente.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
