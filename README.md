# mutation-test-example
This is a simple mutatation test example made in Java

## Analyze with SonarQube

Firstly, run the unit tests:

```bash
mvn clean verify
```

Then, make sure SonarQube is running and run the command below:

```bash
mvn sonar:sonar \
  -Dsonar.projectKey=java-mutation-test-example \
  -Dsonar.host.url=http://localhost:9001 \
  -Dsonar.login=b7000af14a4c5dac23772680fce5ec238ce8f8c7
```

## Run mutation test suite

Once unit tests have been executed let's run the mutation tests:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

## Improvement after mutation tests

Checking the mutation test results, 9/10 mutation tests passed, and the failed one is due to a negated conditional that
can be exposed with the next mutant:

```diff
public class Palindrome {
    public boolean isPalindrome(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            if (inputString.length() > 1) {
                var firstChar = inputString.charAt(0);
                var lastChar = inputString.charAt(inputString.length() - 1);
                var mid = inputString.substring(1, inputString.length() - 1);
-               return (firstChar == lastChar) && isPalindrome(mid);
+               return (firstChar == lastChar) && !isPalindrome(mid);
            } else {
                return true;
            }
        }
    }
}
```

The results of the defined unit test will be all passed even included this change, so the mutant will survive. To avoid
it we can just include a new test case as below:

```java
@Test
public void nearPalindrom(){
        Palindrome palindromeTester=new Palindrome();
        assertFalse(palindromeTester.isPalindrome("neon"));
        }
```