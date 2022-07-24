package com.example.javadevelopment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Path.of(RESOURCES + "txt.csv");
        final List<String > lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFrom(lines);
        System.out.println("The total for all transactions is " + calculateAmount(bankTransactions));
        System.out.println("The total for all transaction is " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        final List<BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth()  == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
         }
        return bankTransactionInMonth;
    }

    private static double calculateAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(final  BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

}
