package first_commit.sung.entity.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Getter
@Setter
public class HistoryDto {
    private Integer totalnum;
    private List<Integer> recenthis = new ArrayList<>();
}
