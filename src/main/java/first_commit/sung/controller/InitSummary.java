package first_commit.sung.controller;


import first_commit.sung.entity.Summary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitSummary {

    private final InitSummaryService initSummaryService;


    @PostConstruct
    public void init(){
        initSummaryService.init();
    }

    @Component
    static class InitSummaryService{
        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init(){
            Summary summaryOne = new Summary("{ one }");
            Summary summaryTwo = new Summary("{ two }");
            Summary summaryThree = new Summary("{ three }");
            Summary summaryFour = new Summary("{ four }");
            Summary summaryFive = new Summary("{ five }");

            em.persist(summaryOne);
            em.persist(summaryTwo);
            em.persist(summaryThree);
            em.persist(summaryFour);
            em.persist(summaryFive);
            em.flush();
        }
    }

}
