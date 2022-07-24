package com.example.javadevelopment;

import java.time.Month;

/** 람다를 사용 하기로 한다*/
@Deprecated
public class BankTransactionInFebruaryAndExpensive implements BankStatementProcessor.BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
