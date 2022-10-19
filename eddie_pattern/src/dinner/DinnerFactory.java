package dinner;

public class DinnerFactory extends Factory{
	public Meal makeMeal() { return new Dinner(); }
}
