package week1practice;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.List;

public class PersistenceService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamesService");

    private EntityManager em = this.emf.createEntityManager();

    private EntityTransaction tx = this.em.getTransaction();

    public <T> void save(T entity){
        this.tx.begin();
        this.em.persist(entity);
        this.tx.commit();
    }

    public List<Game> getAllGamesDynamicQuery(){
        String query = "SELECT g FROM games g";

        return this.em.createQuery(query).getResultList();
    }

    public List<Game> getAllGamesNamedQuery(){
        return this.em.createNamedQuery("getAllGamesNamedQuery").getResultList();
    }

    public List<Game> getAllGamesCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Game.class);
        Root gameRoot = criteriaQuery.from(Game.class);
        criteriaQuery.select(gameRoot);
        return this.em.createQuery(criteriaQuery).getResultList();
    }

    public List<Game> getAllGamesIfPlayerNameIsPlayingDynamic(){
        Query query = this.em.createQuery("select g from games g join g.players p where p.name = 'jack'");

        return query.getResultList();
    }

    public List<Game> getAllGamesIfPlayerNameIsPlayingNamed(){
        Query query = this.em.createNamedQuery("getAllGamesIfPlayerNameIsPlayingNamed");

        return query.getResultList();
    }

    public List<Game> getAllGamesIfPlayerNameIsPlayingCriteria(){
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<Game> query = criteriaBuilder.createQuery(Game.class);
        Root<Game> gameRoot = query.from(Game.class);
        Join<Object, Object> playing = gameRoot.join("players");
        Predicate namePredicate = criteriaBuilder.equal(playing.get("name"), "jack");
        query.where(namePredicate);
        return this.em.createQuery(query).getResultList();
    }
}
