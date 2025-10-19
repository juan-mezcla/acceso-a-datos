package tarea6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import tarea6.Main;

class MostrarAlumnos {
	static final String ARCHIVO_TEST = "alumnos_test.dat";
	@Test
	void test() {
		File arch=new File(ARCHIVO_TEST);
		
		Main.anadirAlumno(arch);
		
		assertTrue(Main.mostrarAlumnos(arch));
	}

}
