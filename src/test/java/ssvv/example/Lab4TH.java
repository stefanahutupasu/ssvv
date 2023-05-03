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
import validation.Validator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Lab4TH {

    @Test
    public void testAddStudent_Incremental() {
        StudentXMLRepository fileRepository1 = mock(StudentXMLRepository.class);
        TemaXMLRepository fileRepository2 = mock(TemaXMLRepository.class);
        Validator<Nota> notaValidator = new NotaValidator();
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        // create a new instance of the service class with the mock repositories
        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        Student student = new Student("20", "Doe", 124);

        // define the behavior of the student repository mock object
        when(fileRepository1.save(student)).thenReturn(student);

        // add the student
        int result = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(result, 0);

    }

    @Test
    public void testAddAssignment_AddStudent() {
        // create mock objects of the repositories
        StudentXMLRepository fileRepository1 = mock(StudentXMLRepository.class);
        TemaXMLRepository fileRepository2 = mock(TemaXMLRepository.class);
        Validator<Nota> notaValidator = new NotaValidator();
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        // create a new instance of the service class with the mock repositories
        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        Student student = new Student("20", "Doe", 124);

        // define the behavior of the student repository mock object
        when(fileRepository1.save(student)).thenReturn(student);

        // add the student
        int result = service.saveStudent(student.getID(), student.getNume(), student.getGrupa());

        // verify that the student was added successfully
        assertEquals(result, 0);

        // create a new assignment to add
        Tema tema = new Tema("5", "desc", 13, 12);

        // define the behavior of the assignment repository mock object
        when(fileRepository2.save(tema)).thenReturn(tema);

        // add the assignment
        int result2 = service.saveTema(tema.getID(),tema.getDescriere(),tema.getDeadline(),tema.getStartline());

        // verify that the assignment was added
        assertEquals(result2, 0);

    }



}
