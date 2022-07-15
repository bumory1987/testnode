package first_commit.sung.entity.dto;

import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SummaryDe {
   private Long id;
   private InfoDto infoDto;
    private LocalDateTime createdDate;
}
