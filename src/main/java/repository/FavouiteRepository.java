package repository;

import controller.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouiteRepository extends JpaRepository<Favourite, Long> {
}
