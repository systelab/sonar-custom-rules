package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Rule(key = "AvoidAssertEquals")
public class AvoidAssertEqualsRule extends IssuableSubscriptionVisitor {

  private static final List<String> ASSERTION_CLASSES = Arrays.asList("org.junit.Assert", "junit.framework.TestCase", "junit.framework.Assert",
    "org.junit.jupiter.api.Assertions");

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.METHOD_INVOCATION);
  }

  @Override
  public void visitNode(Tree tree) {
    if (!(tree instanceof MethodInvocationTree)) {
      return;
    }

    MethodInvocationTree methodInvocation = (MethodInvocationTree) tree;

    Symbol.MethodSymbol methodSymbol = methodInvocation.methodSymbol();

    if (methodSymbol != null) {

      Symbol.TypeSymbol owner = methodSymbol.enclosingClass();

      if (owner != null) {
        String fullClassName = owner.type()
          .fullyQualifiedName();

        if ("assertEquals".equals(methodInvocation.methodSelect().toString()) && ASSERTION_CLASSES.contains(fullClassName)) {
          reportIssue(methodInvocation.methodSelect(), "Use \"org.assertj.core.api.Assertions.assertThat\" instead.");
        }

      }
    }
  }
}
