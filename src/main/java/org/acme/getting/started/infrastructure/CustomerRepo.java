package org.acme.getting.started.infrastructure;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import org.acme.getting.started.entity.Customer;

public interface CustomerRepo extends PanacheEntityResource<Customer, Long> {
}
