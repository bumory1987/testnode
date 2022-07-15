package first_commit.sung.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import first_commit.sung.entity.Summary;
import first_commit.sung.entity.dto.HistoryDto;
import first_commit.sung.entity.dto.InfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitSummary {

    private final InitSummaryService initSummaryService;


    @PostConstruct
    public void init(){
        initSummaryService.init();
    }

    @Component
    static class InitSummaryService{
        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init(){
            HistoryDto historyDto = new HistoryDto();
            historyDto.setTotalnum(10);
            List<Integer> addList = new ArrayList<>();
            addList.add(1);
            addList.add(2);
            addList.add(3);
            historyDto.setRecenthis(addList);
            InfoDto infoDtoOne = new InfoDto("20220715", "sung",historyDto );
            Gson gson = new Gson();
            String addOne = gson.toJson(infoDtoOne);
            System.out.println("addOne = " + addOne);
            Summary summaryOne = new Summary(addOne);


            HistoryDto historyDtoTwo = new HistoryDto();
            historyDtoTwo.setTotalnum(9);
            List<Integer> addListTwo = new ArrayList<>();
            addListTwo.add(2);
            addListTwo.add(3);
            addListTwo.add(4);
            historyDtoTwo.setRecenthis(addListTwo);
            InfoDto infoDtoTwo = new InfoDto("20220715", "sungbum",historyDtoTwo );
            String addTwo = gson.toJson(infoDtoTwo);
            Summary summaryTwo = new Summary(addTwo);

            em.persist(summaryOne);
            em.persist(summaryTwo);

            em.flush();
        }
    }

}
