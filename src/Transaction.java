

class Transaction
{
    String type;
    double amount;
    Account to;
    Account from;
    String purchaseBusiness;

    // constructor for either deposit or withdrawal
    Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        to = null;
        from = null;
        purchaseBusiness = null;
    }

    // constructor for transferOut or transferIn
    Transaction(double amount, Account toOrFromAccount, String inOrOut){
        if (inOrOut.equals("out") || inOrOut.equals("Out"))  {
            type = "Transfer Out";
            this.amount = amount;
            to = toOrFromAccount;
            from = null;
            purchaseBusiness = null;
        } else if (inOrOut.equals("in") || inOrOut.equals("In")) {
            type = "Transfer In";
            this.amount = amount;
            to = null;
            this.from = toOrFromAccount;
            purchaseBusiness = null;

        }
        else {
            throw new IllegalArgumentException("Invalid transaction direction: " + inOrOut + ". Only 'in' or 'out' are accepted.");
        }
    }

    Transaction(double amount, String purchaseBusiness){
        type = "Purchase";
        this.amount = amount;
        to = null;
        from = null;
        this.purchaseBusiness = purchaseBusiness;
    }




}
