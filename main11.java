package Collection1;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class main11 {
	
	
	
	    public static void main(String[] args) {
	        TransactionHistory transactionHistory = new TransactionHistory();

	        
	        ExecutorService executor = Executors.newFixedThreadPool(10);

	       
	        Runnable producerTask = () -> {
	            for (int i = 0; i < 5; i++) {
	                String transactionId = UUID.randomUUID().toString();
	                long timestamp = System.currentTimeMillis();
	                String type = "BUY";
	                double amount = Math.random() * 10;

	                Transaction transaction = new Transaction(transactionId, timestamp, type, amount);

	                transactionHistory.add(transaction);

	                System.out.println("Added: " + transaction);
	            }
	        };

	        
	        Runnable consumerTask = () -> {
	            while (true) {
	                if (!transactionHistory.isEmpty()) {
	                    Transaction transaction = transactionHistory.get(0);
	                    transactionHistory.remove(transaction);
	                    System.out.println("Processed: " + transaction);
	                }
	            }
	        };

	        
	        for (int i = 0; i < 5; i++) {
	            executor.submit(producerTask);
	        }

	        
	        for (int i = 0; i < 5; i++) {
	            executor.submit(consumerTask);
	        }

	        
	        try {
	            Thread.sleep(5000); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }

	        executor.shutdownNow();
	        
	        TransactionProcessor processor = new TransactionProcessor(50);
	        processor.startProcessing(5, 5);
	    }
	}



