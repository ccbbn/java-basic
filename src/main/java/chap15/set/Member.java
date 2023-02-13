package chap15.set;


import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor


public class Member {
    String name;
    int age;


    // 1. hashCode() 값이 같은지 2. equals() 값이 같은지
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (member.name.equals(this.name) && (member.age == this.age)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}

