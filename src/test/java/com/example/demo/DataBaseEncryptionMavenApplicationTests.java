package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

class DataBaseEncryptionMavenApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 * 
	 * private static final Logger log =
	 * LoggerFactory.getLogger(DataBaseEncryptionMavenApplicationTests.class);
	 * 
	 * @Autowired private CardDetailRepository cardDetailRepository;
	 * 
	 * @Test void testDataReadDecrypted() { CardDetail cardDetail = new
	 * CardDetail(2l, "Being Crazy Dev", "1234567812345678", "12/30");
	 * cardDetailRepository.save(cardDetail);
	 * 
	 * CardDetail cd = cardDetailRepository.findById(cardDetail.getId()).orElse(new
	 * CardDetail()); Assertions.assertEquals(cardDetail.getNumber(),
	 * cd.getNumber()); log.info("Name: {}, cardNumber: {}, expiry: {}",
	 * cd.getName(), cd.getNumber(), cd.getExpiry()); }
	 * 
	 * @Test public void testEncryptDataStore() throws SQLException { CardDetail
	 * cardDetail = new CardDetail(null, "Being Crazy Dev", "1234567812345678",
	 * "12/30"); cardDetailRepository.save(cardDetail);
	 * 
	 * Connection con = DriverManager.getConnection("jdbc:h2:mem:db", "sa", "");
	 * 
	 * PreparedStatement stmt =
	 * con.prepareStatement("select * from card_detail where id = ?");
	 * stmt.setLong(1, cardDetail.getId());
	 * 
	 * ResultSet rs = stmt.executeQuery(); rs.next(); String cardNumber =
	 * rs.getString("card_number");
	 * Assertions.assertNotEquals(cardDetail.getNumber(), cardNumber);
	 * log.info("CardNumber in database: {}", cardNumber);
	 * 
	 * }
	 */

	//To test the effect first update the converter to StringAttributeConverterFirst and when test fail, User the
	// StringAttributeConverter
//	@Test
	/*public void testConcurrentAccess() throws InterruptedException, ExecutionException {
		var cardDetail = new CardDetail(null, "Being Crazy Dev", "1234567812345678", "12/30");
		cardDetailRepository.save(cardDetail);

		ExecutorService executorService = Executors.newFixedThreadPool(16);
		var completableFuture = new ArrayList<CompletableFuture<String>>();
		for (int i = 0; i < 5000; i++) {
			int finalI = i;
			completableFuture.add(CompletableFuture.supplyAsync(() -> {
				cardDetailRepository.save(
						new CardDetail(null, "Being Crazy Dev", "1234567812345678" + finalI, "12/30"));
				return "done";
			}, executorService));
		}

		completableFuture = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			int finalI = i;
			completableFuture.add(CompletableFuture.supplyAsync(() -> {
				log.info(cardDetailRepository.findById((long) finalI).orElseGet(CardDetail::new).getCardNumber());
				return "done";
			}, executorService));
		}
		CompletableFuture.allOf(completableFuture.toArray(new CompletableFuture[0])).get();
	}*/

	/*
	 * @Test public void testEncryptorKey() { PooledPBEStringEncryptor encryptor =
	 * new PooledPBEStringEncryptor(); SimpleStringPBEConfig config = new
	 * SimpleStringPBEConfig();
	 * 
	 * config.setPassword("secretKey@123"); config.setAlgorithm("PBEWithMD5ANDDES");
	 * config.setKeyObtentionIterations("1000"); config.setPoolSize("1");
	 * config.setProviderName("SunJCE");
	 * config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
	 * config.setStringOutputType("base64"); encryptor.setConfig(config);
	 * 
	 * String plainText = "Admin@123";
	 * System.out.println(encryptor.encrypt("encryptedKey : "+plainText));
	 * 
	 * }
	 */
	
	
}
