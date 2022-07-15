package first_commit.sung.repository.querydsl;


import com.google.gson.Gson;
import com.querydsl.jpa.impl.JPAQueryFactory;
import first_commit.sung.entity.dto.QSummaryDto;
import first_commit.sung.entity.dto.SummaryDto;
import lombok.extern.slf4j.Slf4j;

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
        Gson gson = new Gson();

        return queryFactory
                .select(new QSummaryDto(
                        summary.id,
                        summary.info,
                        summary.createdDate))
                .from(summary).limit(condition.getLimit()).fetch();
    }



}
