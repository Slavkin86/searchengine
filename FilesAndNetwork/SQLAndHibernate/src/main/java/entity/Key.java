package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Key implements Serializable {

    public Key() {
    }

    public Key(int studentId, int courseId){
        this.courseId = courseId;
        this.studentId = studentId;
    }
    @Column(name = "student_id")
    public int studentId;

    @Column(name = "course_id")
    public int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (studentId != key.studentId) return false;
        return courseId == key.courseId;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + courseId;
        return result;
    }
}
