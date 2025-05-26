package assignment;

final class AccountingDpt extends Department {

    public void accounting() {
        System.out.println("Custom accounting");
    }

    @Override
    public String toString() {
        return "Accounting";
    }
}
