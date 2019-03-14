package lt.v;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor

public class Salary {
    @Id
    @Column(name = "person_id")
    private int id;
    @NonNull
    private int pay;

    private Salary() {

    }

}
