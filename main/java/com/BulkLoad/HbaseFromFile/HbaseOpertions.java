package com.BulkLoad.HbaseFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HbaseOpertions {
	private final TableName table = TableName.valueOf("MovieLense");
	public void run(org.apache.hadoop.conf.Configuration config,String inpath) throws IOException{
		readFilesAndLoadTOArrayList(table,inpath,config);
		}	
	public void put(Admin admin, Table tableX,MovieLense movieLense) throws IOException{
		Put p = new Put(Bytes.toBytes(movieLense.movieId));
		for(int i=0; i< movieLense.columns.length; i++){
		p.addImmutable(movieLense.colFam.getBytes(), movieLense.columns[i].getBytes(),movieLense.colVals[i].getBytes());
		}
		tableX.put(p);
	}
	public void hbaseOperations(Configuration config,MovieLense movieLense) throws IOException{
		try (Connection connection = ConnectionFactory.createConnection(config)) {
			Admin admin = connection.getAdmin();
			System.out.println("manoj" + admin);
			if (admin.tableExists(table) && ("userId".equals(movieLense.userId))) {
	            deleteTable(admin);
	        }
			if(!admin.tableExists(table)){
				createTable(admin,movieLense);
			}
			Table tableX = connection.getTable(table);
            System.out.println("kumar" + admin +" " + table);
            if(! "userId".equals(movieLense.userId))
            put(admin, tableX,movieLense);
            tableX.close();
            connection.close();
            
      //      get(tableX);
      //      scan(tableX);
		}
	}
	public void createTable(Admin admin,MovieLense movieLense) throws IOException{
		HTableDescriptor desc = new HTableDescriptor(table);
		desc.addFamily(new HColumnDescriptor(movieLense.colFam));
        admin.createTable(desc);
        System.out.println("table created");
	}
	public void deleteTable(Admin admin) throws IOException{
		admin.disableTable(table);
		admin.deleteTable(table);
	}
	private void readFilesAndLoadTOArrayList(TableName table2, String inpath,Configuration config) throws IOException {
		// TODO Auto-generated method stub
		List <Put> ratingsPut = new ArrayList<Put>();
		List <Put> moviesPut = new ArrayList<Put>();
		List <Put> linksPut = new ArrayList<Put>();
		List <Put> tagsPut = new ArrayList<Put>();
		File[] localDir = new File(inpath).listFiles();
		BufferedReader br = null;
		MovieLense movieLense = new MovieLense();
		for(File file : localDir){
			String CurrentLine;
			br = new BufferedReader(new FileReader(file));
		   
			while((CurrentLine=br.readLine())!=null){
					movieLense.parse(file.getName(),CurrentLine);                  
						hbaseOperations(config,movieLense);
				}
				
			}
		}

	}


