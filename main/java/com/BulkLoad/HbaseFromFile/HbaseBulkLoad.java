package com.BulkLoad.HbaseFromFile;

import java.io.IOException;

import com.google.protobuf.ServiceException;
public class HbaseBulkLoad {
	public static void main(String[] args) throws IOException, ServiceException {
	   HbaseConnect hbaseconnect = new HbaseConnect();
	   hbaseconnect.connect(args[0]);
   }	
}
