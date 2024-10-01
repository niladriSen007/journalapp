package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.service.journal.JournalService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journal")
@AllArgsConstructor
public class JournalController {


    private JournalService journalService;

    @PostMapping("/add")
    public void addJournal(@RequestBody JournalModel journalModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        journalService.addJournal(journalModel, authentication.getName());
    }

    @GetMapping("/get")
    public List<JournalModel> getJournalsByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return journalService.getJournalsByUserName(authentication.getName());
    }

    @PutMapping("/update")
    public void updateJournal(@RequestBody JournalModel journalModel,@RequestParam ObjectId journalId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        journalService.updateJournal(journalModel,journalId,authentication.getName());
    }

    @DeleteMapping("/delete")
    public void deleteJournal(@RequestParam ObjectId journalId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        journalService.deleteJournal(authentication.getName(),journalId);
    }
}
