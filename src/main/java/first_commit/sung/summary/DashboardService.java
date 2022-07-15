package first_commit.sung.summary;


import first_commit.sung.entity.Summary;
import first_commit.sung.entity.dto.SummaryDto;
import first_commit.sung.repository.SummaryRepository;
import first_commit.sung.repository.querydsl.SummaryCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {
    @Autowired
    private SummaryRepository summaryRepository;

    public List<SummaryDto> showSummaryList(Integer count){
        SummaryCondition summaryCondition = new SummaryCondition(count);
        return summaryRepository.findSummaryWithCondition(summaryCondition);
    }


    public Summary save(String info){
        Summary summary = new Summary(info);
        Summary saveSummary = summaryRepository.save(summary);
        return saveSummary;
    }
}
