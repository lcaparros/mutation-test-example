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

### Run mutation test suite

Once unit tests have been executed let's run the mutation tests:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```