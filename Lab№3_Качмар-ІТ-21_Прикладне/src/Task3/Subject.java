package Task3;

import java.util.Objects;

public class Subject {
    private String subject;
    private Mark mark;

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(final Mark mark) {
        this.mark = mark;
    }

    public Subject(final String subject, final Mark mark) {
        this.subject = subject;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject='" + subject + '\'' +
                ", mark=" + getMark() +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final Subject subject1 = (Subject) o;
        return subject.equals(subject1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }
}