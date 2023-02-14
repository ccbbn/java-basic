package chap15.check.q8;


import chap15.set.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Student {

    public int studentNum;
    public String name;


    @Override
    public int hashCode() {
        return this.studentNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student member = (Student) obj;
            if (member.studentNum == this.studentNum) return true;
            else return false;
        }
        return false;
    }
}


