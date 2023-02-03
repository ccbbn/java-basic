package chap08.Check.Q4;

public class MySqlDao implements DataAccessObject{
    @Override
    public void select() {
        System.out.println("sql 선택");
    }

    @Override
    public void insert() {
        System.out.println("sql삽입");
    }

    @Override
    public void update() {
        System.out.println("sql 갱신");

    }

    @Override
    public void delete() {
        System.out.println("sql 삭제");
    }
}
