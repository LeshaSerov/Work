package domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Pharm implements Serializable{
    Integer id;
    String address;
    Integer count;
    List<Preparat> preparatList;

    public Pharm(Integer id, String address){
        this.id = id;
        this.address = address;
    }

    public Pharm(Integer id, String address, Integer count){
        this.id = id;
        this.address = address;
        this.count = count;
    }
}
