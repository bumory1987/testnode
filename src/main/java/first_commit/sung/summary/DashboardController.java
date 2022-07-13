package first_commit.sung.summary;


import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardFacade dashboardFacade;


    @ResponseBody
    @GetMapping("/dashboard_summary")
    public String summary(){
        return dashboardFacade.getJsonList();
    }

}
