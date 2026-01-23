package com.example.fizz_buzz_combo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameRule extends BaseEntity<String>{
    @Id
    private String id;

    private String name;
    private String description;

    public static GameRule create(String id,String name,String description){
        GameRule gameRule = new GameRule();
        gameRule.id = id;
        gameRule.name = name;
        gameRule.description = description;
        return gameRule;
    }
}
