package com.example.fizz_buzz_combo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity<String>{
    @Id
    private String uid;

    private String name;
    private String email;

    @Override
    public String getId() {
        return uid;
    }

    public static User create(String uid,String name,String email){
        User user = new User();
        user.uid=uid;
        user.name=name;
        user.email=email;

        return user;
    }
}
