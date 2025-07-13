package Discovery_service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userdetails, Long> {
    Optional<Userdetails> findByUsername(String username);
}


