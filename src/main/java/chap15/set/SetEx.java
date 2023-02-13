package chap15.set;

import java.util.HashSet;
import java.util.Set;

public class SetEx {
    /// 주머니와 같다
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//
//        set.add("HD");
//        set.add("GG");
//        set.add("KK");
//        set.add("JY");
//
//        System.out.println("set.size() = " + set.size());
//        Iterator<String> iterator = set.iterator();
//
//        while (iterator.hasNext()) {
//            String name = iterator.next();
//            System.out.println(iterator.next());
//
//            if (name.equals("HD")) {
//                iterator.remove();
//            }
//        }
//
//
//        for (String element : set) {
//            System.out.println(element);
//        }

        Set<Member> members = new HashSet<>();

        members.add(new Member("김현덕", 20));
        System.out.println(members.size());
        members.add(new Member("김지영", 25));
        System.out.println(members.size());


        members.add(new Member("종각",20));


    }
}
