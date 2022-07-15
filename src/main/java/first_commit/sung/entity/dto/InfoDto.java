package first_commit.sung.entity.dto;


import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class InfoDto {
    private String testd;
    private String user;
    private HistoryDto history;
}
