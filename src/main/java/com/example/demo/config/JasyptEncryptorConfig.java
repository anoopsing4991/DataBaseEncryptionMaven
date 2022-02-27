package com.example.demo.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.hibernate5.encryptor.HibernatePBEStringEncryptor;
import org.jasypt.salt.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptEncryptorConfig {
	/*
	 * @Bean public void EncryptionConfig() { PooledPBEStringEncryptor encryptor =
	 * new PooledPBEStringEncryptor(); encryptor.setPoolSize(4);
	 * encryptor.setPassword("MY-PASSPASSPASS123");
	 * encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
	 * encryptor.setIvGenerator(new RandomIvGenerator());
	 * encryptor.setKeyObtentionIterations(1500);
	 * 
	 * HibernatePBEEncryptorRegistry registry =
	 * HibernatePBEEncryptorRegistry.getInstance();
	 * registry.registerPBEStringEncryptor("myStringEncryptor", encryptor); }
	 */
	public EnvironmentStringPBEConfig encryptorConfiguration(){

	    EnvironmentStringPBEConfig encryptor = new EnvironmentStringPBEConfig();
	    encryptor.setAlgorithm("PBEWithMD5AndDES");
	    encryptor.setPassword("MY-PASSPASSPASS123");
	    encryptor.setSaltGenerator(new SaltGenerator() {
			
			@Override
			public boolean includePlainSaltInEncryptionResults() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public byte[] generateSalt(int lengthBytes) {
				// TODO Auto-generated method stub
				
				return new byte[lengthBytes];
			}
		});
	    return encryptor;
	}

	public StandardPBEStringEncryptor standardStringEncryptor(){

	    StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
	    stringEncryptor.setConfig(encryptorConfiguration());
	    return stringEncryptor;
	}

	@Bean
	@Autowired
	public HibernatePBEStringEncryptor hibernateStringEncryptor(){
	    HibernatePBEStringEncryptor stringEncryptor = new HibernatePBEStringEncryptor();
	    stringEncryptor.setEncryptor(standardStringEncryptor());
	    stringEncryptor.setRegisteredName("myStringEncryptor");
	    return stringEncryptor;
	}
}
