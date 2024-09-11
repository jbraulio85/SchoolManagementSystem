package com.braulioecheverria;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI{
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        } else {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> estudiantesEnCurso = inscripciones.get(idCurso);
        if (estudiantesEnCurso == null) {
            estudiantesEnCurso = new ArrayList<>();
            inscripciones.put(idCurso, estudiantesEnCurso);
        }
        if (!estudiantesEnCurso.contains(estudiante)) {
            estudiantesEnCurso.add(estudiante);
        } else {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> estudiantesEnCurso = inscripciones.get(idCurso);
        if (estudiantesEnCurso == null || !estudiantesEnCurso.removeIf(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
        }
    }
}
