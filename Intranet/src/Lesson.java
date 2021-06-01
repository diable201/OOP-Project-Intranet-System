import java.util.Objects;

/**
* @generated
*/
public class Lesson {

    public Lesson() {}

    public Lesson(LessonType type, Integer time, Day day) {
        this.type = type;
        this.time = time;
        this.day = day;
    }

    /**
    * @generated
    */
    private LessonType type;

    /**
    * @generated
    */
    private Integer time;

    /**
    * @generated
    */
    private Day day;

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        if (type != lesson.type) return false;
        if (!Objects.equals(time, lesson.time)) return false;
        return day == lesson.day;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "type=" + type +
                ", time=" + time +
                ", day=" + day +
                '}';
    }
}
