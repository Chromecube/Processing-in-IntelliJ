package me.niklas.processingtest;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Niklas on 19.07.2019 in processingtest
 * <p>
 * Short disclaimer: Most of the code here was written by Daniel Shiffman.
 * You can find it in the procesing examples at https://processing.org/examples/bouncingball.html .
 * The only changes I made were the introduction of a radius variable and adding the "highest point" lines.
 */
public class BouncingBall extends PApplet {

    PVector location;  // Location of shape
    PVector velocity;  // Velocity of shape
    PVector gravity;   // Gravity acts at the shape's acceleration
    int r; //radius
    boolean positive = false;
    Map<PVector, PVector> lines = new HashMap<>();

    public static void main(String[] args) {
        PApplet.main("me.niklas.processingtest.BouncingBall");
    }

    public void settings() {
        size(400, 400);
        location = new PVector(100, 100);
        velocity = new PVector(1.5f, 2.1f);
        gravity = new PVector(0, 0.2f);
        r = 12;
    }

    public void draw() {
        background(0);

        location.add(velocity);
        velocity.add(gravity);

        if ((location.x + r > width) || (location.x - r < 0)) {
            velocity.x = velocity.x * -1;
        }
        if (location.y > height - r) {
            velocity.y = velocity.y * -0.95f;
            location.y = height - r;
        }
        if (positive && velocity.y > 0) {
            positive = false;
            lines.put(new PVector(0, location.y), new PVector(width, location.y));
        } else if (!positive && velocity.y < 0) {
            positive = true;
        }

        noStroke();
        fill(255);
        ellipse(location.x, location.y, 2 * r, 2 * r);

        strokeWeight(1);
        stroke(255);
        lines.forEach((start, end) -> line(start.x, start.y, end.x, end.y));
    }
}
