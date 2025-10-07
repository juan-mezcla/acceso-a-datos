package Tarea4;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa a un alumno con toda la informacion que se necesita almacenar del mismo.
 * 
 * <p>Esta clase implementa {@link Serializable} para poder escribir y leer los datos en un archivo binario</p>
 * 
 * @author Juan
 * @version 1.0
 */
public class Alumno implements Serializable {

    /**versión de serialización de la clase alumno. */
    private static final long serialVersionUID = 1L;

    /** Número de identificación del alumno. */
    private int nia;
    /** Nombre del alumno. */
    private String nombre;
    /** Apellidos del alumno. */
    private String apellidos;
    /** Ciclo formativo al que pertenece el alumno. */
    private String ciclo;
    /** Curso actual del alumno. */
    private String curso;
    /** Grupo asignado del alumno. */
    private String grupo;
    /** Género del alumno ('M' o 'F'). */
    private char genero;
    /** Fecha de matrícula o inscripción. */
    private LocalDate fecha;

    /** Formato para mostrar las fechas. */
    static DateTimeFormatter formatoFech = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /** Acumulador para generar datos de ejemplo en el constructor por defecto. */
    static int acumulador = 1;

    /**
     * Constructor vacio para pruebas.
     * <p>
     * Crea un nuevo alumno con datos generados automáticamente a partir del valor de
     * {@code acumulador} para poder hacer las pruebas necesarias.
     * </p>
     */
    public Alumno() {
        this.nia = acumulador;
        this.nombre = "nombre" + acumulador;
        this.apellidos = "apellidos" + acumulador;
        this.ciclo = "ciclo" + acumulador;
        this.curso = "curso" + acumulador;
        this.grupo = "grupo" + acumulador;
        this.genero = (acumulador % 2 == 0) ? 'M' : 'F';
        this.fecha = LocalDate.now().plusMonths(acumulador);
        acumulador++;
    }

    /**
     * Constructor en caso de que se pasen todos los parametros para los datos del alumno.
     *
     * @param nia número identificativo del alumno
     * @param nombre nombre del alumno
     * @param apellidos apellidos del alumno
     * @param ciclo ciclo formativo al que pertenece
     * @param curso curso del alumno
     * @param grupo grupo asignado
     * @param genero género del alumno ('M' o 'F')
     * @param fecha fecha de matrícula
     */
    public Alumno(int nia, String nombre, String apellidos, String ciclo, String curso,
                  String grupo, char genero, LocalDate fecha) {

        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciclo = ciclo;
        this.curso = curso;
        this.grupo = grupo;
        this.genero = genero;
        this.fecha = fecha;
    }

    /**
     * Devuelve los datos del alumno en formato texto.
     *
     * @return una cadena con todos los datos del alumno formateados
     */
    @Override
    public String toString() {
        String fechaFormat = fecha.format(formatoFech);
        return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo=" + grupo
                + ", genero=" + genero + ", fecha=" + fechaFormat + "]";
    }

    /** @return el número identificativo del alumno */
    public int getNia() { return nia; }

    /** @return el nombre del alumno */
    public String getNombre() { return nombre; }

    /** @param nombre el nuevo nombre del alumno */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return los apellidos del alumno */
    public String getApellidos() { return apellidos; }

    /** @param apellidos los nuevos apellidos del alumno */
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    /** @return el ciclo formativo del alumno */
    public String getCiclo() { return ciclo; }

    /** @param ciclo el nuevo ciclo formativo */
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }

    /** @return el curso actual del alumno */
    public String getCurso() { return curso; }

    /** @param curso el nuevo curso */
    public void setCurso(String curso) { this.curso = curso; }

    /** @return el grupo del alumno */
    public String getGrupo() { return grupo; }

    /** @param grupo el nuevo grupo asignado */
    public void setGrupo(String grupo) { this.grupo = grupo; }

    /** @return el género del alumno ('M' o 'F') */
    public char getGenero() { return genero; }

    /** @param genero el nuevo género ('M' o 'F') */
    public void setGenero(char genero) { this.genero = genero; }

    /** @return la fecha de inscripción del alumno */
    public LocalDate getFecha() { return fecha; }

    /** @param fecha la nueva fecha de inscripción */
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
