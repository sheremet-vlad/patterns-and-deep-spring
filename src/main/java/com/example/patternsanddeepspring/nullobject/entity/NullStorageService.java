package com.example.patternsanddeepspring.nullobject.entity;

import org.springframework.stereotype.Service;

@Service
public class NullStorageService extends StorageService {

	@Override
	public void save(Report report) {
		System.out.println("Null object save method. Doing nothing");
	}
}
