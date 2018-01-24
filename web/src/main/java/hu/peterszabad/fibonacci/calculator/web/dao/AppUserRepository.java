package hu.peterszabad.fibonacci.calculator.web.dao;

import hu.peterszabad.fibonacci.calculator.web.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Péter Szabad
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByName(String name);
}
