package com.example.loginapp.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findById(Integer id) {
        return em.find(User.class, id);
    }


    public User save(User user) { // 비영속 객체 (날짜랑 프라이머리키 (PK) 없음!)
        System.out.println(user.getId()); // 여기선 null
        em.persist(user); // PK 있는 객체
        System.out.println(user.getId());
        return user; // 영속 객체
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(
                em.createQuery("select u from User u where u.username = :username", User.class)
                        .setParameter("username", username)
                        .getSingleResult()
        );
    }
}
