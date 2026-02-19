package com.app;

import com.geometry.Circle;
import com.geometry.Rectangle;
import com.geometry.Triangle;
import com.geometry.threed.Cube;
import com.geometry.threed.Cylinder;
import com.geometry.threed.Sphere;
import com.geometry.threed.ThreeDUtils;

import java.util.ArrayList;
import java.util.List;

public class GeometryApplication {
    public static void main(String[] args) {
        System.out.println("=== ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ (2D и 3D) ===\n");

        // 2D фигуры
        System.out.println("--- ДВУХМЕРНЫЕ ФИГУРЫ ---");
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4, 5);

        print2DInfo(circle, rectangle, triangle);

        // 3D фигуры (новая функциональность)
        System.out.println("\n--- ТРЕХМЕРНЫЕ ФИГУРЫ (версия 1.0.0-SNAPSHOT) ---");
        Sphere sphere = new Sphere(5);
        Cube cube = new Cube(4);
        Cylinder cylinder = new Cylinder(3, 7);

        print3DInfo(sphere, cube, cylinder);

        // Сравнение 3D фигур
        System.out.println("\n=== СРАВНЕНИЕ 3D ФИГУР ===");

        List<Object> shapes3d = new ArrayList<>();
        shapes3d.add(sphere);
        shapes3d.add(cube);
        shapes3d.add(cylinder);

        System.out.println("По объему (возрастание):");
        shapes3d.sort((o1, o2) -> ThreeDUtils.compareByVolume(o1, o2));
        for (Object shape : shapes3d) {
            System.out.printf("  %s: объем = %.2f%n",
                    shape.getClass().getSimpleName(), ThreeDUtils.getVolume(shape));
        }

        System.out.println("\nПо площади поверхности (возрастание):");
        shapes3d.sort((o1, o2) -> ThreeDUtils.compareBySurfaceArea(o1, o2));
        for (Object shape : shapes3d) {
            System.out.printf("  %s: площадь поверхности = %.2f%n",
                    shape.getClass().getSimpleName(), ThreeDUtils.getSurfaceArea(shape));
        }
    }

    private static void print2DInfo(Circle c, Rectangle r, Triangle t) {
        System.out.println("Круг:");
        System.out.printf("  Радиус: %.2f, площадь: %.2f, периметр: %.2f%n",
                c.getRadius(), c.getArea(), c.getPerimeter());

        System.out.println("Прямоугольник:");
        System.out.printf("  Ширина: %.2f, высота: %.2f, площадь: %.2f, периметр: %.2f%n",
                r.getWidth(), r.getHeight(), r.getArea(), r.getPerimeter());

        System.out.println("Треугольник:");
        System.out.printf("  Стороны: %.2f, %.2f, %.2f, площадь: %.2f, периметр: %.2f%n",
                t.getSideA(), t.getSideB(), t.getSideC(), t.getArea(), t.getPerimeter());
    }

    private static void print3DInfo(Sphere s, Cube c, Cylinder cy) {
        System.out.println("Сфера:");
        System.out.printf("  Радиус: %.2f, объем: %.2f, площадь поверхности: %.2f%n",
                s.getRadius(), s.getVolume(), s.getSurfaceArea());

        System.out.println("Куб:");
        System.out.printf("  Сторона: %.2f, объем: %.2f, площадь поверхности: %.2f, диагональ: %.2f%n",
                c.getSide(), c.getVolume(), c.getSurfaceArea(), c.getSpaceDiagonal());

        System.out.println("Цилиндр:");
        System.out.printf("  Радиус: %.2f, высота: %.2f, объем: %.2f, площадь поверхности: %.2f%n",
                cy.getRadius(), cy.getHeight(), cy.getVolume(), cy.getSurfaceArea());
    }
}
