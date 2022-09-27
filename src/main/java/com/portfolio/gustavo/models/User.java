package com.portfolio.gustavo.models;


import java.util.Set;
import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;






@Entity
@Table(name = "usuario")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column
private String username;

@Column
private String password;

@Column
private boolean enabled;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name="authorities_users",
joinColumns=@JoinColumn(name="usuario_id"),
inverseJoinColumns=@JoinColumn(name="authority_id"))
private Set<Authority> authority;


public User() {
}

public User(Long id, String username, String password, boolean enabled, Set<Authority> authority) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.authority = authority;
}

//Getters y Setters

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 :id.hashCode());
    return result;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

	this.password = bCryptPasswordEncoder.encode(password);
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public Set<Authority> getAuthority() {
	return authority;
}

public void setAuthority(Set<Authority> authority) {
	this.authority = authority;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    User other = (User) obj;
    if (id == null) {
        if (other.id != null)
            return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
}

@Override
public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
}

}