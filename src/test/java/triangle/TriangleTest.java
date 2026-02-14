package triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

import org.junit.jupiter.api.Test;

/** Test class for the Triangle implementation. */
public class TriangleTest {

  /** Wrapper to avoid code duplication in test methods. */
  private void testTriangle(Type expected, int a, int b, int c) {
    assertEquals(expected, Triangle.classify(a, b, c));
  }

  @Test
  public void testDummy() {
    // Cover the default constructor.
    Triangle a = new Triangle();
  }

  @Test
  public void testTable() {
    //CC Test Cases 
    testTriangle(INVALID, 0, 0, 0);
    testTriangle(INVALID, 0, 0, 1);
    testTriangle(INVALID, 0, 1, 0);
    testTriangle(INVALID, 0, 1, 1);
    testTriangle(INVALID, 1, 0, 0);
    testTriangle(INVALID, 1, 0, 1);
    testTriangle(INVALID, 1, 1, 0);
    testTriangle(ISOSCELES, 2, 2, 3);
    testTriangle(ISOSCELES, 2, 3, 3);
    testTriangle(ISOSCELES, 3, 2, 3);
    testTriangle(INVALID, 1, 2, 3);
    testTriangle(INVALID, 2, 3, 1);
    testTriangle(INVALID, 3, 2, 1);
    testTriangle(SCALENE, 2, 3, 4);
    testTriangle(EQUILATERAL, 4, 4, 4);
    testTriangle(INVALID, 2, 2, 5);
    testTriangle(INVALID, 2, 5, 2);
    testTriangle(INVALID, 5, 2, 2);
  }
}
