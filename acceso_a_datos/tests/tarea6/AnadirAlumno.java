package tarea6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarea6.Main;

class AnadirAlumno {

	static final String ARCHIVO_TEST = "alumnos_test.dat";
	@Test
	void test() {
		File arch=new File(ARCHIVO_TEST);
		
		assertTrue(Main.anadirAlumno(arch));
		assertTrue(Main.anadirAlumno(arch));
	}

}
