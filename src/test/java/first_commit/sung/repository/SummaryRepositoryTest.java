package first_commit.sung.repository;

import first_commit.sung.entity.Summary;
import first_commit.sung.entity.dto.SummaryDto;
import first_commit.sung.repository.querydsl.SummaryCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class SummaryRepositoryTest {

    @Autowired
    private SummaryRepository summaryRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @Commit
    public void simpleTest(){
//        Summary summary = new Summary("{ sung }");
//        summaryRepository.save(summary);
//
//
//        Summary findSum = summaryRepository.findById(summary.getId()).get();
//
//        assertThat(findSum).isEqualTo(summary);

        summaryRepository.save(new Summary("{ sung }"));
        summaryRepository.save(new Summary("{ jun }"));
        summaryRepository.save(new Summary("{ bro }"));
        summaryRepository.save(new Summary("{ hello }"));
        summaryRepository.save(new Summary("{ friend }"));

        em.flush();
        em.clear();

        List<SummaryDto> summaryWithCondition = summaryRepository.findSummaryWithCondition(new SummaryCondition(3));

        summaryWithCondition.stream().forEach(item -> {
            System.out.println(item);
        });


    }


}