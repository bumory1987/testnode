package first_commit.sung.summary;


import com.google.gson.JsonObject;
import first_commit.sung.repository.querydsl.SummaryCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final DashboardFacade dashboardFacade;


    @ResponseBody
    @GetMapping("/dashboard_summary")
    public String summary(@RequestParam(name= "count", required = false) String count){
        int param = 5;
        try{
            param = Integer.parseInt(count);
        }catch (Exception e){
        }

        return dashboardFacade.getJsonList(param);
    }

    @ResponseBody
    @RequestMapping("/receiver")
    public String getJson(@RequestParam("jsonfile") String jsonfile){
        log.info("data ={}",jsonfile );
        return jsonfile;
    }





}
