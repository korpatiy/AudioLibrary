package com.example.AudioLibrary.repositories;

import com.example.AudioLibrary.dto.SearchRequest;
import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализует {@link CustomTextSearcherRepository}
 */
@Repository
public class CustomSearchImpl implements CustomTextSearcherRepository {

    private final EntityManager em;

    public CustomSearchImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Melody> findAllByRequest(SearchRequest request) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Melody> cq = cb.createQuery(Melody.class);
        Root<Melody> melodyRoot = cq.from(Melody.class);
        List<Predicate> p = new ArrayList<>();

        if (request.getName() != null) {
            p.add(cb.like(melodyRoot.get("name"), contains(request.getName())));
        }
        if (request.getComposer() != null) {
            if (request.getComposer().getFirstName() != null)
                p.add(cb.like(melodyRoot.get("composer").get("firstName"), contains(request.getComposer().getFirstName())));
            if (request.getComposer().getLastName() != null)
                p.add(cb.like(melodyRoot.get("composer").get("lastName"), contains(request.getComposer().getLastName())));
        }
        if (request.getGenres() != null) {
            for (Genre genre : request.getGenres()) {
                p.add(cb.like(melodyRoot.join("genres").get("name"), contains(genre.getName())));
            }
        }
        if (request.getSingers() != null) {
            for (Singer singer : request.getSingers()) {
                if (singer.getFirstName() != null)
                    p.add(cb.like(melodyRoot.join("singers").get("firstName"), contains(singer.getFirstName())));
                if (singer.getLastName() != null)
                    p.add(cb.like(melodyRoot.join("singers").get("lastName"), contains(singer.getLastName())));
            }
        }
        cq.where(p.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }

    private String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }

    /*public static Specification<Melody> fetch(String name, String composerName) {
        return new Specification<Melody>() {
            @Override
            public Predicate toPredicate(Root<Melody> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(builder.equal(root.get("name"), name));
                predicates.add(builder.equal(root.get("composer").get("firstName"), composerName));
                return builder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }*/

    /*public static Specification<Melody> nameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("name"), contains(expression));
    }

    public static Specification<Melody> composerFNContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("composer").get("firstName"), contains(expression));
    }

    public static Specification<Melody> composerLNContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("composer").get("lastName"), contains(expression));
    }

    public static Specification<Melody> genreContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("genres").get("name"), contains(expression));
    }*/
}
