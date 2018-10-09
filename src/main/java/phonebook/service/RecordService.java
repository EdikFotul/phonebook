package phonebook.service;

import phonebook.repository.RecordRepo;
import phonebook.requestbody.Record;
import phonebook.requestbody.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {

    @Autowired
    private RecordRepo recordRepo;

    @Transactional
    public  Iterable<Record> saveAndShowAllRecords(String firstName, String lastName, String patronymic, String phoneNumber, String address, String email, User user) {
        Record record = new Record(firstName, lastName, patronymic, phoneNumber, address, email, user);

        recordRepo.save(record);

        return recordRepo.findRecordsByUserId(user.getId());
    }

    @Transactional
    public Iterable<Record> findRecordsByUserId(Long id){
        return recordRepo.findRecordsByUserId(id);
    }

    @Transactional
    public void deleteByEmail (String email){
       recordRepo.deleteRecordByEmail(email);
    }
}
