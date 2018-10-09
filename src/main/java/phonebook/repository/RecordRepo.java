package phonebook.repository;

import phonebook.requestbody.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends CrudRepository<Record, Integer> {


    Iterable<Record> findRecordsByUserId (Long id);

    void deleteRecordByEmail (String email);
}
