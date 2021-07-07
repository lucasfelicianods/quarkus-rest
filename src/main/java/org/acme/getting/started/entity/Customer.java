package org.acme.getting.started.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String name;

    private String cpf;

    public Customer findCustomer(final String name) {
        return find("name",name ).firstResult();
    }

    public void createCustomer(final Customer customer) {
        customer.persist();
    }

    public static Customer getName(String name) {
        return Customer.find("from Customer c where c.name = ?1", name).firstResult();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
