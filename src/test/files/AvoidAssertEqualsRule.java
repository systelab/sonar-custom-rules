import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class AvoidAssertEqualsRule {

   int result = 5;

   void t1(){
     assertEquals(5, result); // Noncompliant
     assertThat(result).isEqualTo(5);
   }
}
