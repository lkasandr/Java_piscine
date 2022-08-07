package school21.spring.service.models;

import java.util.Objects;

public class User {
    Long id;
    String email;

    public User() {
    }

    public User(Long identifier, String email) {
        this.id = identifier;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long identifier) {
        this.id = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
