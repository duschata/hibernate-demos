/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.demos.jpacditesting;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@ApplicationScoped
public class TransactionalTestService {

    @Inject
    EntityManager entityManager;

    @Transactional(value = TxType.MANDATORY)
    public String doSomething() {
        return "Success";
    }


    @Transactional(value = TxType.REQUIRES_NEW)
    public String saveInNewTransaction(Object o) {
        entityManager.persist(o);
        return "Success";
    }
}
