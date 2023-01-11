package com.example.alumni.Controller;

import com.example.alumni.Bean.AlumniEducation;
import com.example.alumni.Bean.AlumniOrganisation;
import com.example.alumni.DAO.AlumniEducationDAO;
import com.example.alumni.DAO.DAOImplementation.AlumniEducationDAOImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alumni_edu")
public class AlumniEducationController {
    AlumniEducationDAO a=new AlumniEducationDAOImpl();

    @POST
    @Path("/add_edu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_org(List<AlumniEducation> obj)
    {

        if(this.a.addAlumniEducation(obj))
            return Response.status(200).entity("Success").build();
        return Response.status(400).entity("Fail to add list of alumni qualifications").build();
    }
}
