package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Owner;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByFirstName(String firstName);

    List<Owner> findByLastName(String lastName);

    @Procedure(procedureName = "ownerInsertion")
    void ownerInsertion();

    @Procedure(procedureName = "create_databases_for_each_owner")
    void createDatabasesForEachOwner();

    Boolean existsByEmail(String email);

    Optional<Owner> findByEmail(String email);

}
