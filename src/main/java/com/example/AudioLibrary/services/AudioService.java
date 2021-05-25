package com.example.AudioLibrary.services;

import com.example.AudioLibrary.controllers.AudioController;
import com.example.AudioLibrary.entity.Genre;
import com.example.AudioLibrary.entity.Melody;
import com.example.AudioLibrary.entity.Singer;
import com.example.AudioLibrary.repositories.AudioRepository;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AudioService {

    private final AudioRepository repository;

    final
    EntityManager em;

    @Autowired
    public AudioService(AudioRepository repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    public List<Melody> getAll() {
        return repository.findAll();
    }

    public Melody save(Melody melody) {
        return update(melody);
    }

    public Melody update(Melody melody) {
        return repository.save(melody);
    }

    public List<Melody> search(AudioController.SearchRequest request) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("composer", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Melody melody = Melody
                .builder()
                .name(request.getName())
                .composer(request.getComposer())
                .genres(request.getGenres())
                .singers(request.getSingers())
                .build();

        int x = 5;
        //Specification<Melody> melodySpecification = fetchTeam(request.getName(), request.getComposer().getFirstName());

       /* Specification<Melody> specification = Specification
                .where(request.getName() == null ? null : nameContains(request.getName()))
                .or(request.getComposer().getFirstName() == null ? null : composerFNContains(request.getComposer().getFirstName()))
                .or(request.getComposer().getLastName() == null ? null : composerLNContains(request.getComposer().getLastName()))
                .or(request.getGenres() == null ? null : check(request.getGenres()));

        return repository.findAll(specification);*/

        // return repository.findAll(Example.of(melody, matcher));

        //todo в кастом репу
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

    /*public static Specification<Melody> check(Collection<Genre> expression) {
        return new Specification<Melody>() {
            @Override
            public Predicate toPredicate(Root<Melody> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                for (Genre genre : expression) {
                   predicates.add(cb.like(root.get("genres").get("name"), contains(genre.getName())));
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }*/
    //Оно тебя сожрет
    /*public static Specification<Melody> fetchTeam(String name, String composerName) {
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

    public static Specification<Melody> nameContains(String expression) {
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
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}

