package domain;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pharm implements Serializable{
    Integer id;
    String address;
}
