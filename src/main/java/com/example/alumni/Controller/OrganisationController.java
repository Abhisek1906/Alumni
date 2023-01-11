package com.example.alumni.Controller;

import com.example.alumni.Bean.Alumni;
import com.example.alumni.Bean.Organisation;
import com.example.alumni.Bean.Student;
import com.example.alumni.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.alumni.DAO.OrganisationDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/organisation")
public class OrganisationController {
    OrganisationDAO org=new OrganisationDAOImpl();

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all()
    {
        List<Organisation> orgs = this.org.getAll();
        return Response.status(200).entity(orgs).build();

    }


    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_Student(Organisation orgs)
    {
        if(this.org.addOrganisation(orgs))
        {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Fail to add student").build();
    }

    @GET
    @Path("/getOrg/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getOrgByName(@PathParam("name") String name)
    {
        Organisation temp=this.org.getOrgByName(name);
        System.out.println(temp.toString());
        if(temp!=null)
            return Response.status(200).entity(temp).build();
        return Response.status(400).entity("No Organisation registered by that name.").build();
    }

}
