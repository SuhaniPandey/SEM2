package die;

public class VikingDieFactory extends Factory
{
  @Override public Die playgame()
  {
    return new VikingDie();
  }
}
