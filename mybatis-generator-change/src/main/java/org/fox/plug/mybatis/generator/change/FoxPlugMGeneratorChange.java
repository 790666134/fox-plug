package org.fox.plug.mybatis.generator.change;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;


/**
 * 
 * @ClassName: FoxPlugMGeneratorChange  
 * @Description: 项目入口，重写Mybatis-Generator 类说明: mybatis逆向工程main函数
 * @author yang  
 * @date 2018年1月26日  
 *
 */
public class FoxPlugMGeneratorChange {
	
	public static void main(String[] args) {
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 如果这里出现空指针，直接写绝对路径即可。
		String genCfg = "/generator.xml";
		File configFile = new File(FoxPlugMGeneratorChange.class.getResource(genCfg).getFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		try {
			myBatisGenerator.generate(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
