package com.niladri.Journalapp.service.serviceInterface;

import com.niladri.Journalapp.model.JournalModel;

import java.util.List;

public interface ServiceInterface {
    void addJournal(JournalModel journalModel);

    List<JournalModel> getJournal();
}
