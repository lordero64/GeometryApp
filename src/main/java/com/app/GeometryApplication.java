package com.app;

import com.geometry.Circle;
import com.geometry.Rectangle;
import com.geometry.Triangle;
import com.utils.GeometryComparator;
import com.utils.GeometryConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeometryApplication {
    public static void main(String[] args) {
        System.out.println("=== ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ===\n");

        // Создаем фигуры в сантиметрах
        Circle circle = new Circle(500); // радиус 500 см = 5 м
        Rectangle rectangle = new Rectangle(400, 600); // 400x600 см = 4x6 м
        Triangle triangle = new Triangle(300, 400, 500); // 3,4,5 м в см

        System.out.println("ИСХОДНЫЕ ФИГУРЫ (в см):");
        printFigureInfo(circle, rectangle, triangle);

        // Используем GeometryConverter для конвертации в метры
        System.out.println("\n=== КОНВЕРТАЦИЯ В МЕТРЫ (GeometryConverter) ===");
        Circle circleM = GeometryConverter.circleCmToM(circle);
        Rectangle rectangleM = GeometryConverter.rectangleCmToM(rectangle);
        Triangle triangleM = GeometryConverter.triangleCmToM(triangle);

        System.out.println("Фигуры в метрах:");
        System.out.printf("  Круг: радиус = %.2f м, площадь = %.2f м²%n",
                circleM.getRadius(), circleM.getArea());
        System.out.printf("  Прямоугольник: %.2f x %.2f м, площадь = %.2f м²%n",
                rectangleM.getWidth(), rectangleM.getHeight(), rectangleM.getArea());
        System.out.printf("  Треугольник: стороны = %.2f, %.2f, %.2f м, площадь = %.2f м²%n",
                triangleM.getSideA(), triangleM.getSideB(), triangleM.getSideC(), triangleM.getArea());

        // Используем GeometryComparator для сортировки
        System.out.println("\n=== СОРТИРОВКА ФИГУР (GeometryComparator) ===");

        List<Object> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        System.out.println("По площади (возрастание):");
        Collections.sort(shapes, new GeometryComparator.ByArea());
        for (Object shape : shapes) {
            System.out.printf("  %s: площадь = %.2f%n",
                    shape.getClass().getSimpleName(), getArea(shape));
        }

        System.out.println("\nПо периметру (возрастание):");
        Collections.sort(shapes, new GeometryComparator.ByPerimeter());
        for (Object shape : shapes) {
            System.out.printf("  %s: периметр = %.2f%n",
                    shape.getClass().getSimpleName(), getPerimeter(shape));
        }
    }

    private static void printFigureInfo(Circle c, Rectangle r, Triangle t) {
        System.out.printf("  Круг: радиус = %.2f см, площадь = %.2f см², периметр = %.2f см%n",
                c.getRadius(), c.getArea(), c.getPerimeter());
        System.out.printf("  Прямоугольник: %.2f x %.2f см, площадь = %.2f см², периметр = %.2f см%n",
                r.getWidth(), r.getHeight(), r.getArea(), r.getPerimeter());
        System.out.printf("  Треугольник: стороны = %.2f, %.2f, %.2f см, площадь = %.2f см², периметр = %.2f см%n",
                t.getSideA(), t.getSideB(), t.getSideC(), t.getArea(), t.getPerimeter());
    }

    private static double getArea(Object shape) {
        if (shape instanceof Circle) return ((Circle) shape).getArea();
        if (shape instanceof Rectangle) return ((Rectangle) shape).getArea();
        if (shape instanceof Triangle) return ((Triangle) shape).getArea();
        return 0;
    }

    private static double getPerimeter(Object shape) {
        if (shape instanceof Circle) return ((Circle) shape).getPerimeter();
        if (shape instanceof Rectangle) return ((Rectangle) shape).getPerimeter();
        if (shape instanceof Triangle) return ((Triangle) shape).getPerimeter();
        return 0;
    }
}
