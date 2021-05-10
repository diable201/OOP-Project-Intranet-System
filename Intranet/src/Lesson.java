/**
* @generated
*/
public class Lesson {
    
	public Lesson() {
		
	}

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

}
