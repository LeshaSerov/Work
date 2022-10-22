package domain;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Preparat implements Serializable {
    Integer id;
    String name;
}
