# Exception Away

With the introduction of functional paradigm into Java programming language, traditional checked exceptions become a huge mess

```java
Stream.of(
    "http://example.com",
    "http://google.com"
).map(s -> {
    try {
        return new URL(s);
    } catch (MalformedURLException exc) {
        throw new RuntimeException(exc);
    }
}).map(url -> {
    try {
        return url.getContent();
    } catch (IOException exc) {
        throw new RuntimeException(exc);
    }
}).forEach(System.out::println);
```

Imagine we could just ignore them.

```java
Stream.of(
    "http://example.com",
    "http://google.com"
)
.map(URL::new)
.map(URL::getContent)
.forEach(System.out::println);
```

Much better.

Fortunately, checked exceptions exist only during compile-time. 

The main purpose of this library is to trick the compiler by wrapping lambdas that throw checked exceptions into lambdas that do not throw them.

The wrappers are generated at runtime with [LambdaMetafactory]( https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/LambdaMetafactory.html). For example

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(FunctionWrapper.wrap(URL::new))
.map(SupplierWrapper.wrap(URL::getContent))
.forEach(System.out::println);
```

There is a helper to simplify the code even more for frequently used functional interfaces.

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(Helper.uncheck(URL::new))
.map(Helper.uncheck(URL::getContent))
.forEach(System.out::println);
```

The static import helps to achieve maximum brevity.

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(uncheck(URL::new))
.map(uncheck(URL::getContent))
.forEach(System.out::println);
```

&nbsp;