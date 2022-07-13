package first_commit.sung.entity.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SummaryDto {
    private Long id;
    private String info;
    private LocalDateTime createdDate;

    @QueryProjection
    public SummaryDto(Long id , String info, LocalDateTime createdDate){
        this.id = id ;
        this.info = info;
        this.createdDate =createdDate;
    }


}

