package domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pharm implements Serializable{
    Integer id;
    String address;
    List<Preparat> preparatList;

    public Pharm(Integer id, String address){
        this.id = id;
        this.address = address;
    }
}
