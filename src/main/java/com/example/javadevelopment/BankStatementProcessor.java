package com.example.javadevelopment;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * BamlStatementProcessor 클래스의 계산 연산 그룹화
 * */
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0;
        for(final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }


    @Deprecated
    public List<BankTransaction> findTransactionsGreaterEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() >=amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    @Deprecated
    public List<BankTransaction> findTransactionInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    @Deprecated
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }


    @FunctionalInterface
    public interface BankTransactionFilter {
        boolean test(BankTransaction bankTransaction);
    }

    @FunctionalInterface
    public interface BankTransactionSummarizer {
        double summarize(double accumulator, BankTransaction bankTransaction);
    }

}
