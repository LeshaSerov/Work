package db;

import domain.Pharm;
import jakarta.websocket.OnClose;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface Imitator {

    List<Pharm> pharmList = new ArrayList<>();
    static void addPharm(Pharm pharm){
        pharmList.add(pharm);
    }
    static void editPharm(Integer id, String address){
        Optional<Pharm> pharm = pharmList.stream().filter((a) -> Objects.equals(id, a.getId())).findFirst();
        if (pharm.isPresent()) {
            pharm.get().setAddress(address);
            Integer index = pharmList.indexOf(pharm.get());
            pharmList.set(index, pharm.get());
        }
    }
    static void deletePharm(Integer id){
        Optional<Pharm> pharm = pharmList.stream().filter((a) -> Objects.equals(id, a.getId())).findFirst();
        pharm.ifPresent(pharmList::remove);
    }

    static List<Pharm> getPharmList() {
        return pharmList;
    }
}
