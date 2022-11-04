package domain;

import lombok.*;
import org.jetbrains.annotations.ApiStatus;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Preparat implements Serializable {
    Integer id;
    String name;
    Integer count;
    List<Pharm> pharmList;

    public Preparat(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Preparat(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
