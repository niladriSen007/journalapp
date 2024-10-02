package com.niladri.Journalapp.cache;

import com.niladri.Journalapp.model.JournalConfigModel;
import com.niladri.Journalapp.repository.JournalConfigRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

	public enum keys{
		WEATHER_API
	}

	public Map<String, String> APP_CACHE ;

	@Autowired
	private JournalConfigRepository journalConfigRepository;

	@PostConstruct
	public void initialize(){
		APP_CACHE = new HashMap<>();
		List<JournalConfigModel> allPairs = journalConfigRepository.findAll();
		for(JournalConfigModel pair : allPairs){
			APP_CACHE.put(pair.getKey(), pair.getValue());
		}
	}
}

