package com.niladri.Journalapp.service.journal.journalInterface;

import com.niladri.Journalapp.model.JournalModel;

import java.util.List;

public interface JournalInterface {
    void addJournal(JournalModel journalModel);

    List<JournalModel> getJournal();
}
