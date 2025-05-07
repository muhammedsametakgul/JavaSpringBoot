# ✅ Kullanıcı Kayıt API'si – Functional Interface ile Modern Validation (Spring Boot)

Bu proje, Spring Boot kullanılarak geliştirilmiş bir kullanıcı kayıt servisidir. Amacı, klasik static `Utility` sınıfları yerine **fonksiyonel arayüz (Functional Interface)** kullanarak daha sade, test edilebilir ve genişletilebilir bir doğrulama (validation) mimarisi sunmaktır.

---

## 🧠 Functional Interface Nedir?

Java'da `@FunctionalInterface`, **yalnızca tek bir soyut metot** içeren arayüzleri tanımlar. Bu sayede bu arayüzler **lambda ifadeleriyle** kullanılabilir.

Örneğin:
```java
Validator<String> emailValidator = email -> email.contains("@");
```

Bu yapı sayesinde:
- Her doğrulama davranışı küçük birimlere ayrılır
- Gereksiz sınıf oluşturma ihtiyacı ortadan kalkar
- Zincirleme yapılabilir: `.and(...)`
- Test ve değiştirilebilirlik artar

---

## 🚀 Neden Kullandık?

Klasik yapı:
```java
public class ValidationUtil {
    public static boolean isValidEmail(String email) { ... }
}
```
❌ Statik yapılar test edilemez, override edilemez, bağımlılık olarak enjekte edilemez.

Fonksiyonel yapı:
```java
Validator<String> emailValidator = email -> email != null && email.contains("@");
```
✅ Test edilebilir, değiştirilebilir, zincirlenebilir (`.and(...)`) ve esnektir.

---

## 🧱 Proje Yapısı

```
com.example.registration
├── ValidationAsFunctionalInterfaceApplication.java  --> Spring Boot main application class
├── controller
│   └── RegistrationController.java                 --> REST API endpoint (/api/register)
├── model
│   └── User.java                                   --> User data model
├── service
│   └── RegistrationService.java                    --> Handles registration and validation logic
├── validator
│   ├── Validator.java                              --> Functional interface (core validator)
│   └── impl
│       ├── EmailValidator.java                     --> Email validation implementation
│       └── PasswordValidator.java                  --> Password validation implementation
```

---

## 🧪 Doğrulama Mantığı

`Validator<T>` arayüzü şu şekildedir:

```java
@FunctionalInterface
public interface Validator<T> {
    boolean validate(T t);

    default Validator<T> and(Validator<T> other) {
        return t -> this.validate(t) && other.validate(t);
    }
}
```

Böylece validator'ları zincirleyebilirsin:

```java
Validator<String> notEmpty = s -> s != null && !s.isBlank();
Validator<String> hasAt = s -> s.contains("@");

Validator<String> emailValidator = notEmpty.and(hasAt);
```

---

## 📤 Örnek `curl` İstekleri

Aşağıdaki istekleri terminalde çalıştırarak API'yi test edebilirsin:

```bash
# ✅ Geçerli istek (doğru e-posta ve şifre)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "test@example.com", "password": "mypassword"}'

# ❌ Geçersiz e-posta (validator: "@" eksik)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "invalid.com", "password": "mypassword"}'

# ❌ Kısa şifre (validator: en az 8 karakter)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "test@example.com", "password": "123"}'

# ❌ Boş e-posta (validator: boş olamaz)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "", "password": "mypassword"}'
```

---

## 🔍 Özet

- Functional Interface sayesinde doğrulama işlemleri sade ve esnek hale gelir
- `.and(...)` ile kural zincirleme yapılabilir
- Spring Boot ile REST API olarak servis edilir
- Tüm yapı test edilebilir ve genişletilebilir olarak tasarlanmıştır

---

📌 Bu README, projenin amacını, mimarisini ve nasıl test edileceğini anlatan net bir rehber sunar.  
Projeyi `mvn spring-boot:run` ile çalıştırabilir, yukarıdaki `curl` komutlarıyla test edebilirsin.

## ENG
# ✅ User Registration API – Modern Validation with Functional Interface (Spring Boot)

This project is a user registration service built with Spring Boot. The goal is to replace the traditional static `Utility` class approach with **Functional Interface** based validation, resulting in cleaner, more testable, and extensible validation logic.

---

## 🧠 What is a Functional Interface?

In Java, `@FunctionalInterface` marks an interface that has **only one abstract method**, allowing it to be used with **lambda expressions**.

Example:
```java
Validator<String> emailValidator = email -> email.contains("@");
```

Benefits:
- Eliminates the need to create separate classes for simple behaviors
- Clean and readable syntax
- Easily chainable using `.and(...)`
- Great for testing and DI (Dependency Injection)

---

## 🚀 Why Did We Use It?

Traditional approach:
```java
public class ValidationUtil {
    public static boolean isValidEmail(String email) { ... }
}
```
❌ Hard to test, not injectable, not composable.

Functional approach:
```java
Validator<String> emailValidator = email -> email != null && email.contains("@");
```
✅ Testable, chainable, injectable, readable, and flexible.

---

## 🧱 Project Structure

```
com.example.registration
├── ValidationAsFunctionalInterfaceApplication.java  --> Spring Boot main application class
├── controller
│   └── RegistrationController.java                 --> REST API endpoint (/api/register)
├── model
│   └── User.java                                   --> User data model
├── service
│   └── RegistrationService.java                    --> Handles user registration and validation
├── validator
│   ├── Validator.java                              --> Core functional interface for validation
│   └── impl
│       ├── EmailValidator.java                     --> Email validation logic
│       └── PasswordValidator.java                  --> Password validation logic
```

---

## 🧪 Validation Logic

Our core interface:

```java
@FunctionalInterface
public interface Validator<T> {
    boolean validate(T t);

    default Validator<T> and(Validator<T> other) {
        return t -> this.validate(t) && other.validate(t);
    }
}
```

Allows chaining of multiple rules:

```java
Validator<String> notEmpty = s -> s != null && !s.isBlank();
Validator<String> hasAt = s -> s.contains("@");

Validator<String> emailValidator = notEmpty.and(hasAt);
```

---

## 📤 Sample `curl` Requests

You can test the API using the following commands:

```bash
# ✅ Valid request (correct email and password)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "test@example.com", "password": "mypassword"}'

# ❌ Invalid email (missing "@")
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "invalid.com", "password": "mypassword"}'

# ❌ Short password (less than 8 characters)
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "test@example.com", "password": "123"}'

# ❌ Empty email
curl -X POST http://localhost:8080/api/register \
     -H "Content-Type: application/json" \
     -d '{"email": "", "password": "mypassword"}'
```

---

## 🔍 Summary

- Functional Interfaces make your validation logic clean, simple, and reusable
- `.and(...)` allows you to chain multiple validation rules elegantly
- The entire system is designed to be testable and extensible
- This pattern is especially useful in real-world, scalable applications

---

📌 You can run the project with `mvn spring-boot:run` and test it using the `curl` commands above. IDE recommended: IntelliJ IDEA or VS Code with Spring Boot support.
