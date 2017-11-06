package com.example.barungsofthomehwrk.repository.order;

import com.example.barungsofthomehwrk.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final CrudOrderRepository crudOrderRepository;

    @Autowired
    public OrderRepositoryImpl(EntityManager entityManager, CrudOrderRepository crudOrderRepository) {
        this.entityManager = entityManager;
        this.crudOrderRepository = crudOrderRepository;
    }

    @Override
    public List<Order> getByCustomerId(Long id) {
//        return crudOrderRepository.findByCustomer(id);
        Query query=entityManager.createQuery("SELECT o FROM Order o WHERE o.customer.id="+id);
        return query.getResultList();
    }

    @Override
    public Order save(Order order) {
        return crudOrderRepository.save(order);
    }

    @Override
    public boolean isOrder(Long id) {
        return crudOrderRepository.exists(id);
    }
}
