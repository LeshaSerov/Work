package domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categ implements Serializable{
    Integer id;
    String name;
    List<Preparat> preparatList;
}
