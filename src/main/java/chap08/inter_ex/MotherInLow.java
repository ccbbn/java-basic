package chap08.inter_ex;

public class MotherInLow implements Cookable{
    @Override
    public void prepareIngredients() {

    }

    @Override
    public Food cook() {

        return new Food(91);
    }
}
