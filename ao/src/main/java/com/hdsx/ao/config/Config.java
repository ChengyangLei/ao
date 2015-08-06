package com.hdsx.ao.config;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esri.arcgis.interop.AutomationException;
import com.esri.arcgis.system.IPropertySet;
import com.esri.arcgis.system.PropertySet;



public class Config {
	
	private Logger log=LoggerFactory.getLogger(Config.class);
	
	static final Config config = new Config();
	
	private String server;		// 主机
	private String instance;	// 端口
	private String database;	//sde表空间
	private String user;		//Oracle 用户名
	private String password;	//Oracle 密码
	private String version;		//SDE 版本
	private Config() {
	}
	public void init(){
		try {
			InputStream is = getClass().getResourceAsStream("/application.properties");
			Properties dbProps = new Properties();
			dbProps.load(is);
			server   = dbProps.getProperty("server");
			instance = dbProps.getProperty("instance");
			database = dbProps.getProperty("database");
			user     = dbProps.getProperty("user");
			password = dbProps.getProperty("password");
			version  = dbProps.getProperty("version")==null?"sde.DEFAULT":dbProps.getProperty("version");
			if(log.isDebugEnabled())
			{
				log.debug(toString());
			}
		} catch (Exception e) {
			log.error("数据库连接配置文件出错");
			e.printStackTrace();
		}
	}
	public void init (InputStream stream){
		try {
			Properties dbProps = new Properties();
			dbProps.load(stream);
			server   = dbProps.getProperty("server");
			instance = dbProps.getProperty("instance");
			database = dbProps.getProperty("database");
			user     = dbProps.getProperty("user");
			password = dbProps.getProperty("password");
			version  = dbProps.getProperty("version")==null?"sde.DEFAULT":dbProps.getProperty("version");
			if(log.isDebugEnabled())
			{
				log.debug(toString());
			}
		} catch (Exception e) {
			log.error("数据库连接配置文件出错");
			e.printStackTrace();
		}
	}
	public void init(String prop)
	{
		try {
			InputStream is = getClass().getResourceAsStream(prop);
			Properties dbProps = new Properties();
			dbProps.load(is);
			server   = dbProps.getProperty("server");
			instance = dbProps.getProperty("instance");
			database = dbProps.getProperty("database");
			user     = dbProps.getProperty("user");
			password = dbProps.getProperty("password");
			version  = dbProps.getProperty("version")==null?"sde.DEFAULT":dbProps.getProperty("version");
			if(log.isDebugEnabled())
			{
				log.debug(toString());
			}
		} catch (Exception e) {
			log.error("数据库连接配置文件出错");
			e.printStackTrace();
		}
	}
	public IPropertySet initPropertySet(){
		IPropertySet prop=null;
		try 
		{
			if(!(instance.isEmpty()||user.isEmpty()||password.isEmpty()||version.isEmpty()))
			{
				prop=new PropertySet();
				prop.setProperty("server",server);
				prop.setProperty("instance",instance);
				prop.setProperty("database",database);
				prop.setProperty("user",user);
				prop.setProperty("password",password);
				prop.setProperty("version",version);
			}
		} catch (AutomationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Config [log=" + log + ", server="
				+ server + ", instance=" + instance + ", database=" + database
				+ ", user=" + user + ", password=" + password + ", version="
				+ version + "]";
	}
	

}