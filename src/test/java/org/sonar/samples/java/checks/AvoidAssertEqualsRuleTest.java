package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.utils.FilesUtils;

class AvoidAssertEqualsRuleTest {


  /*
   This test class contains a single test, the purpose of which is to verify the behavior of the rule we are going to implement
   To do so, it relies on the usage of the CheckVerifier class, provided by the Java Analyzer rule-testing API.
   This CheckVerifier class provides useful methods to validate rule implementations, allowing us to totally abstract all the mechanisms
   related to analyzer initialization. Note that while verifying a rule, the verifier will collect lines marked as being Noncompliant,
   and verify that the rule raises the expected issues and only those issues.
   */
  @Test
  void detected() {

    CheckVerifier.newVerifier()
      //.onFile(FILENAME)
      .onFile("src/test/files/AvoidAssertEqualsRule.java")
      .withCheck(new AvoidAssertEqualsRule())
      //.withJavaVersion(8)
      .withClassPath(FilesUtils.getClassPath("target/test-jars"))
      .verifyIssues();

  }

}
