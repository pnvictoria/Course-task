package org.example.division;

public class DivisionFormatter {
    private DivisionResult divisionResult;

    public String format(DivisionResult divisionResult) {
        this.divisionResult = divisionResult;
        StringBuilder formattedResult = new StringBuilder("");
        formattedResult.append("_").append(divisionResult.getDividend())
                .append("|")
                .append(divisionResult.getDivider())
                .append("\n");

        int countOfDigitsInDividend = getCountOfDigits(divisionResult.getDividend());
        int countOfDigitsInPeek = getCountOfDigits(getPeekNumber());
        int countOfSpaces = countOfDigitsInDividend - countOfDigitsInPeek;
        int countOfDigitsInResult = getCountOfDigits(divisionResult.getResult());
        formattedResult.append(" ")
                .append(divisionResult.getIntermediateResults().pop())
                .append(repeatSymbol(countOfSpaces, " "))
                .append("|").append(repeatSymbol(countOfDigitsInResult, "-"))
                .append("\n");

        formattedResult.append(" ")
                .append(repeatSymbol(countOfDigitsInDividend - countOfSpaces, "-"))
                .append(repeatSymbol(countOfSpaces, " "))
                .append("|")
                .append(divisionResult.getResult()).append("\n");

        formattedResult.append(displayCalculatingSausage(countOfDigitsInPeek));
        return formattedResult.toString();
    }

    public String repeatSymbol(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public int getCountOfDigits(int number) {
        return number == 0 ? 1 : (int) Math.log10(number) + 1;
    }

    public int getPeekNumber() {
        if (divisionResult.getIntermediateResults().isEmpty()) {
            throw new NullPointerException("List is empty!");
        } else {
            return divisionResult.getIntermediateResults().peek();
        }
    }

    private String displayCalculatingSausage(int countOfDigitsInPrevious) {
        StringBuilder column = new StringBuilder("");
        int countOfDigits = getCountOfDigits(getPeekNumber());
        int numberOfSort = countOfDigitsInPrevious + 1;
        while (divisionResult.getIntermediateResults().size() > 1) {
            numberOfSort++;
            int countOfSpaces = numberOfSort - countOfDigits;
            column.append(repeatSymbol(countOfSpaces - 1, " "))
                    .append("_")
                    .append(divisionResult.getIntermediateResults().pop()).append("\n");
            column
                    .append(repeatSymbol(countOfSpaces, " "))
                    .append(divisionResult.getIntermediateResults().pop())
                    .append("\n");
            column.append(repeatSymbol(countOfSpaces, " "))
                    .append(repeatSymbol(countOfDigits, "-"))
                    .append("\n");
            countOfDigits = getCountOfDigits(getPeekNumber());
        }
        column.append(repeatSymbol(numberOfSort - getCountOfDigits(getPeekNumber()), " "))
                .append(divisionResult.getIntermediateResults().pop());
        return column.toString();
    }


}
