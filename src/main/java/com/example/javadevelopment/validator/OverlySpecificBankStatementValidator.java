package com.example.javadevelopment.validator;

import javax.sound.midi.InvalidMidiDataException;
import java.lang.reflect.UndeclaredThrowableException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class OverlySpecificBankStatementValidator {
    private String description;
    private String date;
    private String amount;

    public  OverlySpecificBankStatementValidator(final String description, final String date, final String amount) {
        this.description = Objects.requireNonNull(description);
        this.date = Objects.requireNonNull(date);
        this.amount = Objects.requireNonNull(amount);
    }

    public Notification validate() {
        final Notification notification = new Notification();
        if(this.description.length() > 100) {
            notification.addError("the description is too long");
        }
       final LocalDate parseDate;
        try{
            parseDate = LocalDate.parse(this.date);
            if(parseDate.isAfter(LocalDate.now()))
                notification.addError("date cannot be in the future");

        }catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }

        final double amount;
        try{
            amount = Double.parseDouble(this.amount);
        }catch (NumberFormatException e){
            notification.addError("Invalid format for amount");
        }
        return notification;
    }

}
