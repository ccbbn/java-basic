package chap08.Check.Q4;

public class OracleDao implements DataAccessObject{
    @Override
    public void select() {
        System.out.println("오라클 선택");
    }

    @Override
    public void insert() {
        System.out.println("오라클 삽입");
    }

    @Override
    public void update() {
        System.out.println("오라클 갱신");

    }

    @Override
    public void delete() {
        System.out.println("오라클 삭제");
    }
}
