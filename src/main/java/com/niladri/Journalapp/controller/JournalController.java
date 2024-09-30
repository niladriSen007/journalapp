package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.service.journal.JournalService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journal")
@AllArgsConstructor
public class JournalController {

    private JournalService journalService;

    @PostMapping("/add")
    public void addJournal(@RequestBody JournalModel journalModel,@RequestParam String username) {
        journalService.addJournal(journalModel,username);
    }

    @GetMapping("/get")
    public List<JournalModel> getJournalsByUsername(@RequestParam String username) {
        return journalService.getJournalsByUserName(username);
    }

    @DeleteMapping("/delete")
    public void deleteJournal(@RequestParam String username,@RequestParam ObjectId journalId){
        journalService.deleteJournal(username,journalId);
    }
}
