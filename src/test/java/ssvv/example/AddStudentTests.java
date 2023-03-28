package ssvv.example;

import domain.Nota;
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

import static org.junit.Assert.*;


public class AddStudentTests {

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
        Student student = new Student("8", "Doe", 124);

        // add the student
        int result = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(result, 0);
    }

    @Test
    public void testAddDuplicateStudent() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new student to add
        Student student = new Student("9", "Doe", 234);

        // add the student
        int firstResult = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(firstResult, 0);

        // try to add the same student again
        int secondResult = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was not added again
        assertEquals(secondResult, 0);
    }

}

