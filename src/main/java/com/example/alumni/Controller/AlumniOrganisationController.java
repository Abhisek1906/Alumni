package com.example.alumni.Controller;

import com.example.alumni.Bean.AlumniOrganisation;
import com.example.alumni.Bean.Organisation;
import com.example.alumni.DAO.AlumniOrganisationDAO;
import com.example.alumni.DAO.DAOImplementation.AlumniOrganisationDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alumniOrganisation")
public class AlumniOrganisationController {
    AlumniOrganisationDAO a=new AlumniOrganisationDAOImpl();

    @POST
    @Path("/add_org")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_org(List<AlumniOrganisation> obj)
    {

        if(this.a.addAlumniOrganisation(obj))
            return Response.status(200).entity("Success").build();
        return Response.status(400).entity("Fail to add list of alumni organisation").build();
    }

}
