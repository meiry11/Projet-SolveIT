package fr.solveit.repository;

import fr.solveit.model.Session;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepo extends JpaRepository<Session, Integer> {
}
