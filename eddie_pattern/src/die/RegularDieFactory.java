package die;

public class RegularDieFactory extends Factory
{
  @Override public Die playgame()
  {
    return new RegularDie();
  }
}
