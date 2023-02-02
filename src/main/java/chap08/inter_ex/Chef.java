package chap08.inter_ex;


public class Chef implements Cookable{
    @Override
    public void prepareIngredients() {
        System.out.println("고급 재료 손질");

    }

    @Override
    public Food cook() {
        return new Food(90);
    };
}
