package com.niladri.Journalapp.service.journal.journalInterface;

import com.niladri.Journalapp.model.JournalModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface JournalInterface {
    void addJournal(JournalModel journalModel,String username);

    List<JournalModel> getJournalsByUserName(String username);

    void deleteJournal(String username, ObjectId journalId);
}
