package first_commit.sung.repository;

import first_commit.sung.entity.Summary;
import first_commit.sung.repository.querydsl.SummaryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> , SummaryRepositoryCustom {

}
