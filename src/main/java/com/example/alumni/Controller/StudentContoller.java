package com.example.alumni.Controller;

import com.example.alumni.Bean.Student;
import com.example.alumni.DAO.DAOImplementation.StudentDAOImpl;
import com.example.alumni.DAO.StudentDAO;
import com.example.alumni.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;
import java.util.List;

@Path("/student")
public class StudentContoller  {
     StudentDAO student=new StudentDAOImpl();
    @POST
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get_student(Student student)
    {
        System.out.println(student.toString());
        Student students= (Student) this.student.getStudent(student);
        System.out.println("fty"+students.toString());

        return Response.status(200).entity(students).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_Student(Student s)
    {
        if(this.student.addStudent(s))
        {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Fail to add student").build();
    }
}
