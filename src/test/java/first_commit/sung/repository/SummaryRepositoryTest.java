package first_commit.sung.repository;

import first_commit.sung.entity.Summary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class SummaryRepositoryTest {

    @Autowired
    private SummaryRepository summaryRepository;

    @Test
    @Commit
    public void simpleTest(){
        Summary summary = new Summary("{ sung }");
        summaryRepository.save(summary);


        Summary findSum = summaryRepository.findById(summary.getId()).get();

        assertThat(findSum).isEqualTo(summary);
    }


}