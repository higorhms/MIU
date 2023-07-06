package com.persistence;

import com.entities.Animal;
import com.entities.Cow;
import com.entities.Farmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;

import java.util.List;

public class PersistenceService {
    private EntityManagerFactory emf;
    private EntityManager em;

    private EntityTransaction tx;

    public PersistenceService() {
        this.emf = Persistence.createEntityManagerFactory("ProgrammingTest1");
        this.em = this.emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }

    public EntityTransaction getTransaction(){
        return this.tx;
    }

    public <T> void save(T entity){
        this.getTransaction().begin();
        this.em.persist(entity);
        this.getTransaction().commit();
    }

    public List<Animal> findAllAnimalsInTheFarmOperatedByJack(){
        return this.em.createQuery("select animal from Farmer farmer join farmer.operatedFarm farm join farm.liveStock animal where farmer.name = 'Jack'").getResultList();
    }

    public List<Farmer> findAllFarmersThatOwnAFarmThatReturnsMoreThan200Profits(){
       return this.em.createNamedQuery("profitQuery").getResultList();
    }

    public List findAllAges(){
        return this.em.createQuery("select f.age from Farmer f").getResultList();
    }



    /*
    * apply the rules but returns a list of farmers, i couldn't finish it on time
    * */
//    public List findAllCowsWeightingMoreThan1200InAFarmOfSizeLessThan300AcresAndTheOwnersAgeIsGreaterThan25(){
//        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
//        CriteriaQuery<Farmer> query = criteriaBuilder.createQuery(Farmer.class);
//        Root<Farmer> farmerRoot = query.from(Farmer.class);
//        Predicate agePredicate = criteriaBuilder.greaterThan(farmerRoot.get("age"), 25);
//        Join<Object, Object> ownedFarmsJoin = farmerRoot.join("ownedFarms");
//        Predicate sizePredicate = criteriaBuilder.lessThan(ownedFarmsJoin.get("size"), 300);
//        Join<Object, Object> liveStockJoin = ownedFarmsJoin.join("liveStock");
//        Predicate weightPredicate = criteriaBuilder.greaterThan(liveStockJoin.get("weight"), 1200);
//        Predicate typePredicate = criteriaBuilder.equal(liveStockJoin.type(), Cow.class);
//
//        Predicate andPredicate = criteriaBuilder.and(agePredicate, sizePredicate,typePredicate, weightPredicate);
//
//        CriteriaQuery<Farmer> finalQuery = query.select(farmerRoot).where(andPredicate);
//
//        return this.em.createQuery(finalQuery).getResultList();
//    }
}
