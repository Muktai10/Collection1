package Collection1;

public class Transaction {

	private final String transactionID;
	private final long timestamp;
	private final String transactionType;
	private final double amount;
	
	public Transaction(String transactionID, long timestamp, String transactionType, double amount) {
        this.transactionID = transactionID; 
        this.timestamp = timestamp;         
        this.transactionType = transactionType; 
        this.amount = amount; 
	}
        
        
        public String getTransactionID() {
            return transactionID;
        }

        
        public long getTimestamp() {
            return timestamp;
        }

        
        public String getTransactionType() {
            return transactionType;
        }

        
        public double getAmount() {
            return amount;
        }

       
        @Override
        public String toString() {
            return "Transaction{" +
                    "transactionID='" + transactionID + '\'' +
                    ", timestamp=" + timestamp +
                    ", transactionType='" + transactionType + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    
    }


