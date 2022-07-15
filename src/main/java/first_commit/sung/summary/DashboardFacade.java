package first_commit.sung.summary;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import first_commit.sung.entity.Summary;
import first_commit.sung.entity.dto.InfoDto;
import first_commit.sung.entity.dto.SummaryDe;
import first_commit.sung.entity.dto.SummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DashboardFacade {
    private final DashboardService dashboardService;

    public List<SummaryDe> getJsonList(int count){
        List<SummaryDto> summaryDtos = dashboardService.showSummaryList(count);
        Gson gson = new Gson();
        List<SummaryDe> summaryDeLsit = summaryDtos.stream().map(item -> {
            String beforeChange = item.getInfo();
            InfoDto infoDto = gson.fromJson(beforeChange, InfoDto.class);
            return new SummaryDe(item.getId(), infoDto, item.getCreatedDate());
        }).collect(Collectors.toList());

        return summaryDeLsit;

    }

    public String save(String info){
        Gson gson = new Gson();
        InfoDto infoDto = gson.fromJson(info, InfoDto.class);
        String jsonInfo = gson.toJson(infoDto);
        Summary save = dashboardService.save(info);
        return "ok";
    }


}
