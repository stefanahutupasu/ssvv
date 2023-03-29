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

import static org.junit.Assert.assertEquals;

public class AddAssignmentTests {


    @Test
    public void testAddAssignmentLowDeadline() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new assignment to add
        Tema tema = new Tema("23", "idk", 0, 12);


        // add the assignment
        int result = service.saveTema(tema.getID(),tema.getDescriere(),tema.getDeadline(),tema.getStartline());

        // verify that the assignment was not added
        assertEquals(result, 1);

    }


    @Test
    public void testAddAssignmentHighDeadline() {
        // create a new instance of the class that manages the students
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // create a new assignment to add
        Tema tema = new Tema("23", "idk", 15, 12);


        // add the assignment
        int result = service.saveTema(tema.getID(),tema.getDescriere(),tema.getDeadline(),tema.getStartline());

        // verify that the assignment was not added
        assertEquals(result, 1);

    }
}
