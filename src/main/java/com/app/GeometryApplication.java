package com.app;

import com.geometry.Circle;
import com.geometry.Rectangle;
import com.geometry.Triangle;

public class GeometryApplication {
    public static void main(String[] args) {
        System.out.println("=== ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ===\n");

        // Создаем объекты различных фигур
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        // Выводим информацию о круге
        System.out.println("КРУГ:");
        System.out.println("  Радиус: " + circle.getRadius());
        System.out.println("  Площадь: " + circle.getArea());
        System.out.println("  Периметр: " + circle.getPerimeter());
        System.out.println();

        // Выводим информацию о прямоугольнике
        System.out.println("ПРЯМОУГОЛЬНИК:");
        System.out.println("  Ширина: " + rectangle.getWidth());
        System.out.println("  Высота: " + rectangle.getHeight());
        System.out.println("  Площадь: " + rectangle.getArea());
        System.out.println("  Периметр: " + rectangle.getPerimeter());
        System.out.println();

        // Выводим информацию о треугольнике
        System.out.println("ТРЕУГОЛЬНИК:");
        System.out.println("  Стороны: " + triangle.getSideA() + ", " +
                triangle.getSideB() + ", " + triangle.getSideC());
        System.out.println("  Площадь: " + triangle.getArea());
        System.out.println("  Периметр: " + triangle.getPerimeter());
        System.out.println();

        // Демонстрируем работу с несколькими фигурами
        System.out.println("=== СРАВНЕНИЕ ПЛОЩАДЕЙ ===");
        System.out.printf("Площадь круга: %.2f%n", circle.getArea());
        System.out.printf("Площадь прямоугольника: %.2f%n", rectangle.getArea());
        System.out.printf("Площадь треугольника: %.2f%n", triangle.getArea());
    }
}
