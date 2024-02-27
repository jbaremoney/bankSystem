class Transaction
{
//Transaction attributes
    String type;
    double amount;
    Account to;
    Account from;
    String purchaseBusiness;
    String date; //in a real application we would just use the system date, but in this case we're making fake numbers so we manually put in different dates.

    // constructor for either deposit or withdrawal
    Transaction(String type, double amount, String date){
        this.type = type;
        this.amount = amount;
        to = null; //Some variables are set to null because for a deposit there is no to or from.
        from = null;
        purchaseBusiness = null;
        this.date = date;
    }

    // constructor for transferOut or transferIn
    Transaction(double amount, Account toOrFromAccount, String inOrOut, String date){ 
        if (inOrOut.equals("out") || inOrOut.equals("Out"))  { //String inOrOut will decide what type of transaction is created
            type = "Transfer Out";
            this.amount = amount;
            to = toOrFromAccount;
            from = null;
            purchaseBusiness = null;
            this.date = date;
        } else if (inOrOut.equals("in") || inOrOut.equals("In")) {
            type = "Transfer In";
            this.amount = amount;
            to = null;
            this.from = toOrFromAccount;
            purchaseBusiness = null;
            this.date = date;

        }
        else {
            throw new IllegalArgumentException("Invalid transaction direction: " + inOrOut + ". Only 'in' or 'out' are accepted.");
        }
    }

    Transaction(double amount, String purchaseBusiness, String date){
        type = "Purchase";
        this.amount = amount;
        to = null;
        from = null;
        this.purchaseBusiness = purchaseBusiness;
        this.date = date;
    }




}
