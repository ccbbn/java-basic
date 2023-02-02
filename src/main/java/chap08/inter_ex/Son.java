package chap08.inter_ex;

public class Son {
    void request(){};
    int requestFood(Cookable cookable){
        cookable.prepareIngredients();
        Food food = cookable.cook();
        return food.tasty;
    };

}
