package tarea6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarea6.Main;

class AnadirAlumno {


	@Test
	void test() {
		File arch=Main.crearArchivo("hello.txt");
		
		assertTrue(Main.anadirAlumno(arch));
	}

}
