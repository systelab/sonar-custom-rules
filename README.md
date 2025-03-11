SonarQube Java Custom Rules
=======

This project defines a custom rule for Java projects. 

It has been built based on these two github projects:

https://github.com/SonarSource/sonar-java/blob/master/docs/CUSTOM_RULES_101.md 

https://github.com/dorian-burihabwa-sonarsource/epfl-sonar-workshop

Both projects explain how to create custom rules. 

For more details about how to write custom rules, please refer to the official tutorial, [Writing Custom Java Rules 101](../CUSTOM_RULES_101.md).

There's also a Youtube video that you can check:  https://www.youtube.com/watch?v=HwQtWJ66Y7c

Writing coding rules in Java is a seven-step process:

1) Create a SonarQube plugin.
2) Put a dependency on the API of the language plugin for which you are writing coding rules.
3) Create as many custom rules as required.
4) Generate the SonarQube plugin (jar file).
5) Place this jar file in the SONARQUBE_HOME/extensions/plugins directory.
6) Restart SonarQube server and assign the rule to a profile


### Step 1 Create a SonarQube plugin

### Step 2 Put a dependency on the API of the language plugin for which you are writing coding rules

Add this dependency in the pom.xml:
```
<dependency>
  <groupId>org.sonarsource.java</groupId>
  <artifactId>sonar-java-plugin</artifactId>
  <type>sonar-plugin</type>
  <version>${sonarjava.version}</version>      
  <scope>provided</scope>
</dependency>
```
### Step 3: Create as many custom rules as required

The project contains the rule AvoidAssertEqualsRule (org.sonar.samples.java.checks.AvoidAssertEqualsRule.java) and other rules already included in the 
workspace downloaded from Sonar Github. 

Rules can only use classes from the Sonar API:

We need to create 3 files for each rule:
1) A test file, which contains Java code used as input data for testing the rule
2) A test class, which contains the rule's unit test
3)  rule class, which contains the implementation of the rule.


### Step 4: Generate the SonarQube plugin (jar file)

To build the JAR, we have to add the parameter '-Dlicense.skip=true', otherwise, some errors are thrown.

```
mvn clean install -Dlicense.skip=true
```
### Step 5: Place this jar file in the SONARQUBE_HOME/extensions/plugins directory

Once we have the JAR, we need to place it in $SONAR_HOME/extensions/plugins.
Check the version of the SonarQube version and <sonar.plugin.api.version> in pom.xml, otherwise we can have errors
deploying the JAR in SonarQube.

### Step 6: Restart SonarQube server and assign the rule to a profile

Once the JAR is deployed, start SonarQube.  
Go to Sonar page, Rules tab, and filter repository by "SystelabSW Custom Repository Java". You can see the new added rule here.
In the profiles page, add the rule to the profile we want to add it (you will need some permissions to do it). 

###


