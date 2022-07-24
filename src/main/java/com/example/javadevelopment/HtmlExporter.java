package com.example.javadevelopment;

public class HtmlExporter implements Exporter{
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<head><title> Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong> The sum is </strong> :" + summaryStatistics.getSum();
        result += "<li><strong> The average is </strong> :" + summaryStatistics.getAverage();
        result += "<li><strong> The max is </strong> :" + summaryStatistics.getMax();
        result += "<li><strong> The min is </strong> :" + summaryStatistics.getMin();
        result += "<ul>";
        result += "<body>";
        return result;
    }
}
