
class LemonadeChange {

    public boolean lemonadeCh(int[] bills) {
        int fiveDollar = 0; // count of $5 bills
        int tenDollar = 0;  // count of $10 bills

        for (int x : bills) {
            if (x == 5) {
                // No change needed, increase count of $5 bills
                fiveDollar++;
            } else if (x == 10) {
                // Needs $5 as change
                if (fiveDollar > 0) {
                    fiveDollar--;
                    tenDollar++;
                } else {
                    return false; // Cannot give change
                }
            } else {
                // x == 20 → Needs $15 as change
                if (fiveDollar > 0 && tenDollar > 0) {
                    // Prefer giving one $10 and one $5
                    fiveDollar--;
                    tenDollar--;
                } else if (fiveDollar >= 3) {
                    // Else, give three $5 bills
                    fiveDollar -= 3;
                } else {
                    return false; // Cannot give change
                }
            }
        }

        return true; // All customers received correct change
    }

    public static void main(String[] args) {
        LemonadeChange sol = new LemonadeChange();

        // Example test case
        int[] bills = {5, 5, 10,10, 20};

        boolean result = sol.lemonadeCh(bills);
        System.out.println("Can provide change to all customers: " + result);
    }
}
