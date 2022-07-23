package com.example.javadevelopment;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLineFrom(List<String> lines);
}
