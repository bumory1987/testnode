package first_commit.sung.repository.querydsl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import first_commit.sung.entity.QSummary;
import first_commit.sung.entity.dto.QSummaryDto;
import first_commit.sung.entity.dto.SummaryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.util.List;

import static first_commit.sung.entity.QSummary.summary;


@Slf4j
public class SummaryRepositoryImpl implements SummaryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private SummaryRepositoryImpl(JPAQueryFactory queryFactory){
        this.queryFactory = queryFactory;
    }

    @Override
    public List<SummaryDto> findSummaryWithCondition(SummaryCondition condition) {
        return queryFactory
                .select(new QSummaryDto(
                        summary.id,
                        summary.info,
                        summary.createdDate))
                .from(summary).limit(condition.getLimit()).fetch();
    }
}
