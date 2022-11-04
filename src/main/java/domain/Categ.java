package domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Categ implements Serializable{
    Integer id;
    String name;
    List<Preparat> preparatList = null;

    public Categ(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
