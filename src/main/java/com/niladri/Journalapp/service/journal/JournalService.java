package com.niladri.Journalapp.service.journal;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.repository.JournalRepository;
import com.niladri.Journalapp.service.journal.journalInterface.JournalInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class JournalService implements JournalInterface {
    private JournalRepository journalRepository;

    @Override
    public void addJournal(JournalModel journalModel) {
        journalRepository.save(journalModel);
    }

    @Override
    public List<JournalModel> getJournal() {
        return journalRepository.findAll();
    }
}
