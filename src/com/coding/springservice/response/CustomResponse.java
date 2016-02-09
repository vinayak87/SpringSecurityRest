package com.coding.springservice.response;

import java.util.HashMap;

public class CustomResponse {
	private final int id;
	   private final HashMap records;

	   public CustomResponse(HashMap records, int id) {
	       this.records = records;
	       this.id = id;
	   }
	   public int getId() {
	       return id;
	   }
	   public HashMap getRecords() {
	       return records;
	   }
}
