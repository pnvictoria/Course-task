package org.example.division;

public class DivisionFormatter {
    private DivisionResult divisionResult;

    public DivisionFormatter() {
    }

    public DivisionFormatter(DivisionResult divisionResult) {
        this.divisionResult = divisionResult;
    }

    public DivisionResult getDivisionResult() {
        return divisionResult;
    }

    public void setDivisionResult(DivisionResult divisionResult) {
        this.divisionResult = divisionResult;
    }

    public String format() {
        StringBuilder formattedResult = new StringBuilder("");
        formattedResult.append("_").append(divisionResult.getDividend())
                .append("|")
                .append(divisionResult.getDivider())
                .append(System.lineSeparator());
        int dividendLength = getCountOfDigits(divisionResult.getDividend());
        int peekFirstLength = getCountOfDigits(peekFirst());
        int spaces = dividendLength - peekFirstLength;
        int result = getCountOfDigits(divisionResult.getResult());
        formattedResult.append(" ")
                .append(divisionResult.getIntermediateResults().pop())
                .append(repeatSymbol(spaces, " "))
                .append("|").append(repeatSymbol(result, "-"))
                .append(System.lineSeparator());

        formattedResult.append(" ")
                .append(repeatSymbol(dividendLength - spaces, "-"))
                .append(repeatSymbol(spaces, " "))
                .append("|")
                .append(divisionResult.getResult())
                .append(System.lineSeparator());

        formattedResult.append(displayCalculatingSausage(peekFirstLength));
        return formattedResult.toString();
    }

    private String repeatSymbol(int count, String with) {
        return with.repeat(count);
    }

    private int getCountOfDigits(int number) {
        return number == 0 ? 1 : (int) Math.log10(number) + 1;
    }

    private int peekFirst() {
        return divisionResult.getIntermediateResults().peekFirst();
    }

    private String displayCalculatingSausage(int countOfDigitsInPrevious) {
        StringBuilder column = new StringBuilder("");
        int countOfDigits = getCountOfDigits(peekFirst());
        int numberOfSort = countOfDigitsInPrevious + 1;
        while (divisionResult.getIntermediateResults().size() > 1) {
            numberOfSort++;
            int countOfSpaces = numberOfSort - countOfDigits;
            column.append(repeatSymbol(countOfSpaces - 1, " "))
                    .append("_")
                    .append(divisionResult.getIntermediateResults().pop())
                    .append(System.lineSeparator());
            column
                    .append(repeatSymbol(countOfSpaces, " "))
                    .append(divisionResult.getIntermediateResults().pop())
                    .append(System.lineSeparator());
            column.append(repeatSymbol(countOfSpaces, " "))
                    .append(repeatSymbol(countOfDigits, "-"))
                    .append(System.lineSeparator());
            countOfDigits = getCountOfDigits(peekFirst());
        }
        column.append(repeatSymbol(numberOfSort - getCountOfDigits(peekFirst()), " "))
                .append(divisionResult.getIntermediateResults().pop());
        return column.toString();
    }
}
