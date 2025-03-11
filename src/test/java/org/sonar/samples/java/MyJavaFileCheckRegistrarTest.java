/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java;

import org.junit.jupiter.api.Test;
//import org.sonar.api.rule.RuleKey;
//import org.sonar.java.checks.verifier.TestCheckRegistrarContext;
import org.sonar.plugins.java.api.CheckRegistrar;

import static org.assertj.core.api.Assertions.assertThat;

class MyJavaFileCheckRegistrarTest {

  @Test
  void checkRegisteredRulesKeysAndClasses() {
    //TestCheckRegistrarContext context = new TestCheckRegistrarContext();
    CheckRegistrar.RegistrarContext context = new CheckRegistrar.RegistrarContext();

    MyJavaFileCheckRegistrar registrar = new MyJavaFileCheckRegistrar();
    registrar.register(context);

    assertThat(context.checkClasses()).hasSize(0);
    assertThat(context.testCheckClasses()).hasSize(1);
    /*
    assertThat(context.mainRuleKeys).extracting(RuleKey::toString).containsExactly(
      "mycompany-java:SpringControllerRequestMappingEntity",
      "mycompany-java:AvoidAnnotation",
      "mycompany-java:AvoidBrandInMethodNames",
      "mycompany-java:AvoidMethodDeclaration",
      "mycompany-java:AvoidSuperClass",
      "mycompany-java:AvoidTreeList",
      "mycompany-java:AvoidMethodWithSameTypeInArgument",
      "mycompany-java:SecurityAnnotationMandatory");

    assertThat(context.mainCheckClasses).extracting(Class::getSimpleName).containsExactly(
      "SpringControllerRequestMappingEntityRule",
      "AvoidAnnotationRule",
      "AvoidBrandInMethodNamesRule",
      "AvoidMethodDeclarationRule",
      "AvoidSuperClassRule",
      "AvoidTreeListRule",
      "MyCustomSubscriptionRule",
      "SecurityAnnotationMandatoryRule");

    assertThat(context.testRuleKeys).extracting(RuleKey::toString).containsExactly(
      "mycompany-java:NoIfStatementInTests","mycompany-java:AvoidAssertEquals");

    assertThat(context.testCheckClasses).extracting(Class::getSimpleName).containsExactly(
      "NoIfStatementInTestsRule", "AvoidAssertEqualsRule" );

     */
  }

}
