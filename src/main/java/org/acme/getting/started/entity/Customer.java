package org.acme.getting.started.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {

    public String name;

    public Customer findCustomer(final String name) {
        return find("name",name ).firstResult();
    }

    public void createCustomer(final Customer customer) {
        customer.persist();
    }

}
