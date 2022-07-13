package first_commit.sung.summary;
import com.google.gson.JsonObject;


import first_commit.sung.entity.dto.SummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DashboardFacade {
    private final DashboardService dashboardService;

    public String getJsonList(int count){
        List<SummaryDto> summaryDtos = dashboardService.showSummaryList(count);
        JsonObject obj = new JsonObject();

        summaryDtos.stream().forEach(item -> {
            JsonObject objTmp = new JsonObject();
            objTmp.addProperty("info", item.getInfo());
            objTmp.addProperty("date", item.getCreatedDate().toString());
            obj.addProperty(item.getId().toString(), objTmp.toString());
        } );
        return obj.toString();

    }


}
