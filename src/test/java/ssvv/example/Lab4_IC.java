package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;


public class Lab4_IC
{
    @Test
    public void testAddStudent() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new student to add
        Student student = new Student("20", "Doe", 124);

        // add the student
        int result = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(result, 0);
        service.deleteStudent("20");
    }

    @Test
    public void testAddAssignment() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new assignment to add
        Tema tema = new Tema("5", "desc", 13, 12);


        // add the assignment
        int result = service.saveTema(tema.getID(),tema.getDescriere(),tema.getDeadline(),tema.getStartline());

        // verify that the assignment was  added
        assertEquals(result, 0);

        service.deleteTema("5");

    }

    @Test
    public void testAddGrade() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new assignment to add
        Nota nota = new Nota(new Pair<>("1", "1"), 10, 13, "super");


        // add the assignment
        int result = service.saveNota("1", "3", 10, 13, "super");

        // verify that the grade was  added
        assertEquals(result, 0);

        service.deleteNota(new Pair<>("1", "3"));

    }

    @Test
    public void testAddGradeIntegration() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);


        Student student = new Student("20", "Doe", 124);

        // add the student
        int result = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(result, 0);

        // create a new assignment to add
        Tema tema = new Tema("5", "desc", 13, 12);


        // add the assignment
        int result2 = service.saveTema(tema.getID(),tema.getDescriere(),tema.getDeadline(),tema.getStartline());

        // verify that the assignment was  added
        assertEquals(result2, 0);

        // create a new assignment to add
        Nota nota = new Nota(new Pair<>("20", "5"), 10, 13, "super");


        // add the assignment
        int result3 = service.saveNota("20", "5", 10, 13, "super");

        // verify that the grade was  added
        assertEquals(result3, 0);

        service.deleteNota(new Pair<>("20", "5"));
        service.deleteTema("5");
        service.deleteStudent("20");

    }

}
