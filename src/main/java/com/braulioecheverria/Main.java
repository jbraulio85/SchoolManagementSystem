package com.braulioecheverria;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "01/01/2000", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "María", "González", "02/02/2001", "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas avanzadas", 4, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Curso de historia universal", 3, "1.0");

        GestorAcademico gestor = new GestorAcademico();

        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }
    }
}