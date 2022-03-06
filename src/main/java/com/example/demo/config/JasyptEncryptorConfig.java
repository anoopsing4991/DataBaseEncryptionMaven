package com.example.demo.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.hibernate5.encryptor.HibernatePBEStringEncryptor;
import org.jasypt.iv.IvGenerator;
import org.jasypt.salt.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JasyptEncryptorConfig {

	@Value("${jasypt.encryptor.password}")
	private String secretKey;

	@Value("${jasypt.encryptor.algorithm}")
	private String algorithm;

	@Value("${jasypt.encryptor.name}")
	private String encryptorRegisteredName;

	public EnvironmentStringPBEConfig encryptorConfiguration() {

		EnvironmentStringPBEConfig encryptor = new EnvironmentStringPBEConfig();

		encryptor.setKeyObtentionIterations(10000);
		encryptor.setAlgorithm(algorithm);
		encryptor.setPassword(secretKey);
		encryptor.setIvGenerator(new IvGenerator() {

			@Override
			public boolean includePlainIvInEncryptionResults() {

				return false;
			}

			@Override
			public byte[] generateIv(int lengthBytes) {

				return new byte[lengthBytes];
			}
		});
		encryptor.setSaltGenerator(new SaltGenerator() {

			@Override
			public boolean includePlainSaltInEncryptionResults() {

				return false;
			}

			@Override
			public byte[] generateSalt(int lengthBytes) {

				return new byte[lengthBytes];
			}
		});
		return encryptor;
	}

	public StandardPBEStringEncryptor standardStringEncryptor() {

		StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
		stringEncryptor.setConfig(encryptorConfiguration());
		return stringEncryptor;
	}

	@Bean
	@Autowired
	public HibernatePBEStringEncryptor hibernateStringEncryptor() {
		HibernatePBEStringEncryptor stringEncryptor = new HibernatePBEStringEncryptor();
		stringEncryptor.setEncryptor(standardStringEncryptor());
		stringEncryptor.setRegisteredName(encryptorRegisteredName);
		return stringEncryptor;
	}
}

