package first_commit.sung.entity;


import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Summary extends BaseObj{

    public Summary(String info){
        this.info = info;
    }

    @Id @GeneratedValue
    @Column(name = "summary_id")
    private Long id;

    private String info;

}
