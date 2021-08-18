package com.cjc.app.fl.master.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.app.fl.master.main.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	Document findByCid(int cid);	
}
