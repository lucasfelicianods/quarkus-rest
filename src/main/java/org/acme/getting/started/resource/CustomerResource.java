package org.acme.getting.started.resource;

import org.acme.getting.started.entity.Customer;
import org.acme.getting.started.infrastructure.CustomerRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class CustomerResource {

    @Inject
    private CustomerRepo repository;

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

}
