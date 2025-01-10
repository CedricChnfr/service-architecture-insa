package fr.insa.tp.orchestratorAction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorHistoryRepository extends JpaRepository<SensorHistory, Long> {
}