package com.niladri.Journalapp.service.journal;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.JournalRepository;
import com.niladri.Journalapp.repository.UserRepository;
import com.niladri.Journalapp.service.journal.journalInterface.JournalInterface;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class JournalService implements JournalInterface {
    private JournalRepository journalRepository;
    private UserRepository userRepository;

    @Override
    public void addJournal(JournalModel journalModel, String username) {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        journalRepository.save(journalModel);
        user.getJournalEntries().add(journalModel);
        userRepository.save(user);

    }

    @Override
    public List<JournalModel> getJournalsByUserName(String name) {
        UserModel user = userRepository.findByUsername(name).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getJournalEntries();
    }

    @Override
    public void deleteJournal(String username, ObjectId journalId) {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        journalRepository.deleteById(journalId);
        user.getJournalEntries().removeIf(journalModel -> journalModel.getId().equals(journalId));
        userRepository.save(user);
    }


}
