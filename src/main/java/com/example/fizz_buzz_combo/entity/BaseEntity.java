package com.example.fizz_buzz_combo.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public abstract ID getId();

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        // Hibernateのユーティリティを使用してプロキシを考慮したクラス比較を行う
        if (Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        
        BaseEntity<?> that = (BaseEntity<?>) o;

        // IDが存在しない（未保存）場合は、インスタンスが同一でない限り不等とみなす
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        // IDではなく定数を返すことで、保存前後での一貫性を保つ
        return Hibernate.getClass(this).hashCode();
    }
}
