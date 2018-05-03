package com.codebind.maven_demo;


import org.testng.annotations.DataProvider;

public class dataproviderclass {

	@DataProvider(name = "searchProvider")
	public static Object[][] getDatafromDataprovider(){
	

		return new Object[][]{


	        {"1","Chrome","1","66","1","Windows 10","2","1280x1024"},
	        {"1","Chrome","1","66","2","Windows 8.1","2","1280x1024"},
	    	{"1","Chrome","1","66","3","Windows 8","2","1280x1024"},
	//    	{"1","Chrome","1","66","4","Windows 7","2","1280x1024"},  
	//    	{"1","Chrome","3","64","9","OS X Mavericks","5","1920x1080"},
		    {"2","firefox","1","60","1","Windows 10","2","1280x1024"},
		    {"2","firefox","1","60","2","Windows 8.1","2","1280x1024"},
		    {"2","firefox","1","60","3","Windows 8","2","1280x1024"},
//		    {"2","firefox","1","60","4","Windows 7","2","1280x1024"},	 
//		    {"2","firefox","3","58","9","OS X Mavericks","5","1920x1080"},
	    	{"4","Internet Explorer","1","11","1","Windows 10","1","1024x768"},
	    	{"4","Internet Explorer","1","11","2","Windows 8.1","2","1280x800"},
//	    	{"4","Internet Explorer","1","11","3","Windows 7","3","1280x1024"},
	    	{"4","Internet Explorer","2","10","1","Windows 8","4","1366x768"},
//	    	{"4","Internet Explorer","2","10","2","Windows 7","5","1440x900"},
//	    	{"4","Internet Explorer","3","9","1","Windows 7","6","1600x1200"},
//	    	{"4","Internet Explorer","4","8","1","Windows 7","7","1680x1050"},
//	    	{"4","Internet Explorer","4","8","2","Windows XP","8","1920x1080"},
//	    	{"4","Internet Explorer","5","7","1","Windows XP","9","1920x1200"},
	    	{"3","Opera","1","50","1","Windows 10","2","1280x1024"},
	    	{"3","Opera","1","50","2","Windows 8.1","2","1280x1024"},
	    	{"3","Opera","1","50","3","Windows 8","2","1280x1024"},
//	    	{"3","Opera","1","50","4","Windows 7","2","1280x1024"},
//	    	{"3","Opera","2","49","9","OS X Mavericks","5","1920x1080"},
//	    	{"6","Safari","6","6","1","OS X Mountain Lion","2","1280x1024"},
	//    	{"6","Safari","5","7","1","OS X Mavericks","5","1920x1080"},
	    	{"6","Safari","7","5.1","1","Windows 10","2","1280x1024"},
	     	{"6","Safari","7","5.1","2","Windows 8.1","2","1280x1024"},
	    	{"6","Safari","7","5.1","3","Windows 8","2","1280x1024"}, 
	    	
	  //  	{"6","Safari","7","5.1","4","Windows 7","2","1280x1024"},
	  //  	{"6","Safari","7","5.1","5","Windows XP","2","1280x1024"},
	    //	{"6","Safari","7","5.1","6","OS X Lion","5","1920x1080"},
	    //	{"5","Microsoft edger","1","16","1","Windows 10","2","1280x1024"},
		//	{"5","Microsoft edger","2","15","1","Windows 10","2","1280x1024"},
		//	{"5","Microsoft edger","3","14","1","Windows 10","2","1280x1024"}
	    	{"1","Chrome","1","66","5","macOS High Sierra","1","1024x768"},
		    {"1","Chrome","1","66","6","macOS Sierra","2","1280x1024"},
		    {"1","Chrome","1","66","7","OS X El Capitan","3","1280x960"},
		   	{"1","Chrome","1","66","8","OS X Yosemite","4","1600x1200"},
		 	{"2","firefox","1","60","5","macOS High Sierra","1","1024x768"},
	    	{"2","firefox","1","60","6","macOS Sierra","2","1280x1024"},
	    	{"2","firefox","1","60","7","OS X El Capitan","3","1280x960"},
	    	{"2","firefox","1","60","8","OS X Yosemite","4","1600x1200"},
	    	{"3","Opera","1","50","5","macOS High Sierra","1","1024x768"},
	    	{"3","Opera","1","50","6","macOS Sierra","2","1280x1024"},
	    	{"3","Opera","1","50","7","OS X El Capitan","3","1280x960"},
	    	{"3","Opera","1","50","8","OS X Yosemite","4","1600x1200"},
	    	{"6","Safari","1","11","1","macOS Sierra","1","1024x768"},
	    	{"6","Safari","2","10.1","1","macOS Sierra","2","1280x1024"},
	    	{"6","Safari","3","9","1","OS X El Capitan","3","1280x1024"},
	    	{"6","Safari","4","8","1","OS X Yosemite","4","1600x1200"}
	    	
	    
	    
		};
		 }	

	}
