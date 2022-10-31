//package db;
//
//import domain.Pharm;
//import jakarta.websocket.OnClose;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.*;
//
//public interface Imitator {
//
//    List<Pharm> pharmList = new ArrayList<>();
//    static void addPharm(String address){
//        Integer id = (int) Math.random()*100000;
//        pharmList.add(new Pharm(id, address));
//    }
//    static void addPharm(Pharm pharm){
//        pharmList.add(pharm);
//    }
//    static void editPharm(Integer id, String address){
//        Optional<Pharm> pharm = pharmList.stream().filter((a) -> Objects.equals(id, a.getId())).findFirst();
//        if (pharm.isPresent()) {
//            pharm.get().setAddress(address);
//            Integer index = pharmList.indexOf(pharm.get());
//            pharmList.set(index, pharm.get());
//        }
//    }
//    static void deletePharm(Integer id){
//        Optional<Pharm> pharm = pharmList.stream().filter((a) -> Objects.equals(id, a.getId())).findFirst();
//        pharm.ifPresent(pharmList::remove);
//    }
//
//    static List<Pharm> getPharmList() {
//        return pharmList;
//    }
//}
