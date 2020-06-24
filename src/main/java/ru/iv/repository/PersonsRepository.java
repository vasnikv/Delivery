package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.iv.entity.Person;

public interface PersonsRepository extends JpaRepository<Person, Long> {

    @Query(value = "select p from Person p where p.login = ?1")
    Person findByLogin(String login);

//    @Query(value = "select c from Coord c where c.vehicle.id = :id")
//    public List<Coord> findLastCoord(Long id, org.springframework.data.domain.Pageable pageable);
//
//    @Query(value = "WITH RECURSIVE r AS (\n" +
//            "SELECT id, x, y, datetime, previous, vehicle_id\n" +
//            "FROM coords\n" +
//            "WHERE id = :lastCoordId and vehicle_id=:id\n" +
//            "UNION\n" +
//            "SELECT c1.id, c1.x, c1.y, c1.datetime, c1.previous, c1.vehicle_id\n" +
//            "FROM coords c1\n" +
//            "   JOIN r\n" +
//            "       ON c1.id = r.previous\n" +
//            ") SELECT * from r where  ( now() - (interval '1 hour' * :depthInHours) ) < r.datetime", nativeQuery = true)
//    public List<Coord> getRouteByVehicle(Long id, Long lastCoordId, int depthInHours);

}
