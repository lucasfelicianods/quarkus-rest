package org.acme.getting.started.resource;

import org.acme.getting.started.entity.Customer;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class CustomerResource {


    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Customer customer) {
        customer.persist();
        return Response.status(201).entity(customer).build();
    }

    @GET
    @Produces("application/json")
    public List<Customer> getAll() {
        return Customer.findAll().list();
    }

    @GET
    @Path("/find")
    public Customer findByName(@QueryParam("name") String name) {
        return Customer.getName(name);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Customer.delete("id", id);
    }

}
