package com.example.HelloEvents.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;
  private String name;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  public Role role;

  @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
  private List<Reservation> reservations;

  public User() {
  }

  public User(Long id, String name, String email, String password, Role role, List<Reservation> reservations) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
    this.reservations = reservations;
  }

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public static class UserBuilder {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private List<Reservation> reservations;

    public UserBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserBuilder role(Role role) {
      this.role = role;
      return this;
    }

    public UserBuilder reservations(List<Reservation> reservations) {
      this.reservations = reservations;
      return this;
    }

    public User build() {
      User user = new User();
      user.setId(id);
      user.setName(name);
      user.setEmail(email);
      user.setPassword(password);
      user.setRole(role);
      user.setReservations(reservations);
      return user;
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
}