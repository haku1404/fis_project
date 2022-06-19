package criminal.repository;


import criminal.model.Person;

import java.util.*;

import static java.util.List.*;

public interface PersonRepo extends AbstractRepo<Person> {
    Optional<Person> findByUsername(String username);

    default Set<Person> findAllByUsernamePart(String part){
        return Set.of();
    }

    Optional<Person> findByCompleteName(String firstName, String lastName);

    Set<Person> findAll();

    int updatePassword(Long personId, String newPass);

    long count();

    default Map<String, Object> findByIdAsMap(Long id) {
        return new HashMap<>();
    }

    default List<Map<String, Object>> findAllAsMaps() {
        return new ArrayList<>();
    }

    default void htmlAllByName(String name) {}

    default int createPerson(Long userId, String username, String firstName, String lastName, String password) {
        return 0;
    }

    default List<String> findAllUsernames() { return of();}

    default List<Person> findAllByLastName(String firstName){return of();};
}
