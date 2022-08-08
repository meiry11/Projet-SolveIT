package fr.solveit.repository;

import fr.solveit.model.Calendrier;
import fr.solveit.model.CalendrierId;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalendrierRepo extends JpaRepository<Calendrier, CalendrierId> {
}
