package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.service.journal.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journal")
@AllArgsConstructor
public class JournalController {

    private JournalService journalService;

    @PostMapping("/add")
    public void addJournal(@RequestBody JournalModel journalModel) {
        journalService.addJournal(journalModel);
    }

    @GetMapping("/get")
    public List<JournalModel> getJournal() {
        return journalService.getJournal();
    }
}
