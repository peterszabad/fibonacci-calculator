# Fibonacci Calculator

## Running the application with default settings
```bash
./mvnw clean install && ./mvnw spring-boot:run -pl web
```

## Overriding the default configuration
```bash
./mvnw clean install && ./mvnw spring-boot:run -Drun.arguments="--<property.name>=<value>" -pl web
```

The highest number that can be passed to the calculator is controlled by the property `fibonacci.calculator.input.max`.

## Access control
The application uses basic authentication and can be accessed with user name `john` and password `abc123`.

