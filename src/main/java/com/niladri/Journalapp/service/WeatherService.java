package com.niladri.Journalapp.service;

import com.niladri.Journalapp.cache.AppCache;
import com.niladri.Journalapp.constants.Constants;
import com.niladri.Journalapp.response.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

	@Value("${weather.api.key}")
	private String weather_APIKEY;

	@Autowired
	private AppCache appCache;

	@Autowired
	private RedisService redisService;

	@Autowired
	private RestTemplate restTemplate;

	public WeatherApiResponse getWeather(String city) {
		WeatherApiResponse redisValue = redisService.getRedisValue(city, WeatherApiResponse.class);
		if (redisValue != null) {
			return redisValue;
		} else {
			String finalUrl = appCache.APP_CACHE.get(AppCache.keys.WEATHER_API.toString()).replace(Constants.API_KEY, weather_APIKEY).replace(Constants.CITY, city);
			ResponseEntity<WeatherApiResponse> exchange = restTemplate.exchange(finalUrl, HttpMethod.GET, null, WeatherApiResponse.class);
			WeatherApiResponse body = exchange.getBody();
			if (body != null) {
				System.out.println("Setting value in redis");
				redisService.setRedisValue(city, body, 3600L);
			}
			return body;
		}
	}
}
