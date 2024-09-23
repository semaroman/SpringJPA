package ru.netology.repository;

import ru.netology.person.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;

@Repository

public interface Repository extends JpaRepository<Persons, Integer> {
    
    @Query("select p from Person p where p.cityOfLiving = :cityofLiving")
    List<Persons> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    @Query("select p from Person p where p.age < :age")
    List<Persons> findByAgeLessThan(@Param("age") int age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")

    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
    
}
