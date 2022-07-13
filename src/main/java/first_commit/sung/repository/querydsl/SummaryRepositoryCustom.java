package first_commit.sung.repository.querydsl;

import first_commit.sung.entity.dto.SummaryDto;

import java.util.List;

public interface SummaryRepositoryCustom {
    List<SummaryDto> findSummaryWithCondition(SummaryCondition condition);
}
