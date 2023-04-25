package Graph;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GraphTestRunner {

  /* @param args the command line arguments */
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(GraphTest.class);
    for (Failure failure: result.getFailures()) {
      System.out.println(failure.toString());
    }
    System.out.println(result.wasSuccessful());
  }
}