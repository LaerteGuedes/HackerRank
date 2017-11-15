package problems;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by laerteguedes on 15/11/17.
 */
public class LibraryFine {

    static int DAY_FINE = 15;
    static int MONTH_FINE = 500;
    static int YEAR_FINE = 10000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nDateBack = new int[3];
        int[] nDateExpected = new int[3];

        for (int i = 0; i < nDateBack.length; i++)
            nDateBack[i] = s.nextInt();

        for (int i = 0; i < nDateExpected.length; i++)
            nDateExpected[i] = s.nextInt();

        LocalDate dateBack = LocalDate.of(nDateBack[2], nDateBack[1], nDateBack[0]);
        LocalDate dateExpected = LocalDate.of(nDateExpected[2], nDateExpected[1], nDateExpected[0]);

        System.out.println(calcFine(dateBack, dateExpected));
    }

    private static int calcFine(LocalDate dateBack, LocalDate dateExpected){

        boolean isInTime = dateBack.isBefore(dateExpected) || dateBack.equals(dateExpected);

        if (isInTime)
            return 0;

        boolean sameMonth = dateBack.getMonth().equals(dateExpected.getMonth());
        boolean sameYear = dateBack.getYear() == dateExpected.getYear();

        if (sameMonth && sameYear)
            return (dateBack.getDayOfMonth()-dateExpected.getDayOfMonth())*DAY_FINE;

        if (!sameMonth && sameYear)
            return (dateBack.getMonthValue()-dateExpected.getMonthValue())*MONTH_FINE;

        return YEAR_FINE;

    }

}
