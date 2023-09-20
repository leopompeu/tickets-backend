package com.littera.ticketsapi.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private UserRole role;
    @NotBlank(message = "O campo não pode estar em branco!")
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String name;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String username;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String password;
    @Email(message = "Email inválido!")
    private String email;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String address;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String city;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String state;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String country;
    @NotBlank(message = "O campo não pode estar em branco!")
    private String postalCode;
    @NotBlank(message = "O campo não pode estar em branco!")
    @CPF(message = "O CPF informado não é válido.")
    private String cpf;
    @NotBlank(message = "O campo não pode estar em branco!")
    private Date birthDate;
    private Date registerDate;
    private Boolean isEnabled;
    private Boolean isNonExpired;
    private Boolean isNonLocked;

    public Users(String username,
                 String password,
                 UserRole role,
                 String name,
                 String email,
                 String address,
                 String city,
                 String state,
                 String country,
                 String postalCode,
                 String cpf,
                 Date birthDate,
                 Date registerDate,
                 Boolean isEnabled,
                 Boolean isNonExpired,
                 Boolean isNonLocked){

        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.isEnabled = isEnabled;
        this.isNonExpired = isNonExpired;
        this.isNonLocked = isNonLocked;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
