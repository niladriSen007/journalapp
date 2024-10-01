package com.niladri.Journalapp.service.journal;

import com.niladri.Journalapp.model.JournalModel;
import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.JournalRepository;
import com.niladri.Journalapp.repository.UserRepository;
import com.niladri.Journalapp.service.journal.journalInterface.JournalInterface;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class JournalService implements JournalInterface {
	private JournalRepository journalRepository;
	private UserRepository userRepository;

	@Override
	@Transactional
	public void addJournal(JournalModel journalModel, String username) {
		UserModel user = userRepository.findByUsername(username);
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		journalRepository.save(journalModel);
		user.getJournalEntries().add(journalModel);
		userRepository.save(user);

	}

	@Override
	public List<JournalModel> getJournalsByUserName(String name) {
		UserModel user = userRepository.findByUsername(name);
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		return user.getJournalEntries();
	}

	@Override
	@Transactional
	public void deleteJournal(String username, ObjectId journalId) {
		UserModel user = userRepository.findByUsername(username);
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		boolean isValidUser = user.getJournalEntries().removeIf(journalModel -> journalModel.getId().equals(journalId));
		if(isValidUser){
			journalRepository.deleteById(journalId);
			userRepository.save(user);
		}else throw new RuntimeException("You have no access to delete this journal");
	}

	@Override
	@Transactional
	public JournalModel updateJournal(JournalModel journalModel,ObjectId journalId, String name) {
		UserModel user = userRepository.findByUsername(name);
		System.out.println(user.getJournalEntries().stream().filter(journalModel1 -> journalModel1.getId().equals(journalId)).toList());
		List validUser = user.getJournalEntries().stream().filter(journalModel1 -> journalModel1.getId().equals(journalId)).toList();
		if(validUser.size() > 0){
			JournalModel journal = journalRepository.findById(journalId).orElse(null);
			if(journal == null) {
				throw new RuntimeException("Journal not found");
			}
			journal.setTitle(journalModel.getTitle());
			journal.setContent(journalModel.getContent());

//		user.getJournalEntries().removeIf(journalModel1 -> journalModel1.getId().equals(journalModel.getId()));
//		user.getJournalEntries().add(journal);
//		userRepository.save(user);
			return journalRepository.save(journal);
		}else{
			throw new RuntimeException("You have no access to update this journal");
		}
	}


}
