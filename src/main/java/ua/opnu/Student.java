package ua.opnu;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Student зберігає інформацію про студента: ім'я, рік навчання
 * та список дисциплін, які він вивчає.
 */
public class Student {

    /** Мінімально допустимий рік навчання. */
    private static final int MIN_YEAR = 1;

    /** Максимально допустимий рік навчання. */
    private static final int MAX_YEAR = 4;

    /** Вартість одного року навчання. */
    private static final int COST_PER_YEAR = 20000;

    /** Ім'я студента. */
    private final String name;

    /** Рік навчання (1-4). */
    private final int year;

    /** Список дисциплін, які вивчає студент. */
    private final List<String> courses;

    /**
     * Конструктор для створення об'єкта Student.
     *
     * @param studentName Ім'я студента.
     * @param studentYear Рік навчання (від 1 до 4).
     */
    public Student(final String studentName, final int studentYear) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім.");
        }
        if (studentYear < MIN_YEAR || studentYear > MAX_YEAR) {
            throw new IllegalArgumentException(
                    "Рік навчання має бути в діапазоні від "
                            + MIN_YEAR + " до " + MAX_YEAR + "."
            );
        }

        this.name = studentName;
        this.year = studentYear;
        this.courses = new ArrayList<>();
    }

    /**
     * Додає дисципліну до списку студента.
     * @param courseName Назва дисципліни.
     */
    public void addCourse(final String courseName) {
        if (courseName != null && !courseName.trim().isEmpty()) {
            this.courses.add(courseName);
        }
    }

    /**
     * Видаляє всі дисципліни зі списку студента.
     */
    public void dropAll() {
        this.courses.clear();
    }

    /**
     * Повертає кількість дисциплін, які вивчає студент.
     * @return Кількість дисциплін.
     */
    public int getCourseCount() {
        return this.courses.size();
    }

    /**
     * Повертає ім'я студента.
     * @return Ім'я студента.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Розраховує та повертає загальну вартість навчання.
     * @return Загальна вартість навчання.
     */
    public int getTuition() {
        return this.year * COST_PER_YEAR;
    }

    /**
     * Повертає рік навчання студента.
     * @return Рік навчання (1-4).
     */
    public int getYear() {
        return this.year;
    }
}
