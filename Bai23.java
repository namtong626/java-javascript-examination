import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bai23 {
    public static void main(String[] args) {
        List<String> dateAndYearList = new ArrayList<>();

        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2023, 0, 1);
        Calendar currentDate = Calendar.getInstance();

        dateAndYearList
                .add(String.format("%d/%d", createdDate.get(Calendar.MONTH) + 1, createdDate.get(Calendar.YEAR)));

        while (createdDate.getTime().before(currentDate.getTime())) {
            createdDate.add(Calendar.MONTH, 1);
            dateAndYearList
                    .add(String.format("%d/%d", createdDate.get(Calendar.MONTH) + 1, createdDate.get(Calendar.YEAR)));
        }

        int salary = 100;
        String givenDateTime = "2023-01-29";
        List<Result> arr = new ArrayList<>();

        for (String date : dateAndYearList) {
            String[] arrDate = date.split("/");

            Calendar currentDateInCalendar = Calendar.getInstance();

            List<Integer> listDate = getDaysInMonth(Integer.parseInt(arrDate[0]), Integer.parseInt(arrDate[1]));

            if (Integer.parseInt(arrDate[0]) == currentDateInCalendar.get(Calendar.MONTH) + 1) {
                List<Integer> listDateCurrent = new ArrayList<>();

                for (int day : listDate) {
                    if (day <= currentDateInCalendar.get(Calendar.DAY_OF_MONTH)) {
                        listDateCurrent.add(day);
                    }
                }

                arr.add(new Result(date, listDateCurrent.size() * salary));
            } else if (Integer.parseInt(arrDate[0]) == Integer.parseInt(givenDateTime.split("-")[1])) {
                List<Integer> listDateStart = new ArrayList<>();

                for (int day : listDate) {
                    if (day >= Integer.parseInt(givenDateTime.split("-")[2])) {
                        listDateStart.add(day);
                    }
                }

                arr.add(new Result(date, listDateStart.size() * salary));
            } else {
                arr.add(new Result(date, listDate.size() * salary));
            }
        }

        for (Result element : arr) {
            System.out.println(element.getDate() + ": " + element.getSalary());
        }
    }

    public static List<Integer> getDaysInMonth(int month, int year) {
        month--;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        List<Integer> days = new ArrayList<>();

        while (calendar.get(Calendar.MONTH) == month) {
            Calendar tmpDate = Calendar.getInstance();
            tmpDate.setTime(calendar.getTime());
            int weekDay = tmpDate.get(Calendar.DAY_OF_WEEK);
            int day = tmpDate.get(Calendar.DAY_OF_MONTH);

            if (weekDay != Calendar.SATURDAY && weekDay != Calendar.SUNDAY) {
                days.add(day);
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return days;
    }

    static class Result {
        private String date;
        private int salary;

        public Result(String date, int salary) {
            this.date = date;
            this.salary = salary;
        }

        public String getDate() {
            return date;
        }

        public int getSalary() {
            return salary;
        }
    }
}