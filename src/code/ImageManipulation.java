package code;

import image.Pixel;
import image.APImage;

public class ImageManipulation {

    /**
     * CHALLENGE 0: Display Image
     * Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
        APImage image = new APImage("cyberpunk2077.jpg");
        image.draw();
    }

    /**
     * CHALLENGE ONE: Grayscale
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     * <p>
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value.
     */
    public static void grayScale(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel pixel = image.getPixel(x, y);
                int average = getAverageColour(pixel);
                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
                image.setPixel(x, y, pixel);
            }
        }
        image.draw();
    }

    /**
     * A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     *
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        return 0;
    }


    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel pixel = image.getPixel(x, y);
                int average = getAverageColour(pixel);
                if (average < 128) {
                    pixel.setRed(0);
                    pixel.setGreen(0);
                    pixel.setBlue(0);
                } else {
                    pixel.setRed(255);
                    pixel.setGreen(255);
                    pixel.setBlue(255);
                }
                image.setPixel(x, y, pixel);
            }
        }
        image.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage image = new APImage(pathToFile);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel currentPixel = image.getPixel(x, y);
                int currentAverage = getAverageColour(currentPixel);
                int leftAverage = (x > 0) ? getAverageColour(image.getPixel(x - 1, y)) : currentAverage;
                int belowAverage = (y > 0) ? getAverageColour(image.getPixel(x, y - 1)) : currentAverage;
                if (Math.abs(currentAverage - leftAverage) > threshold || Math.abs(currentAverage - belowAverage) > threshold) {
                    currentPixel.setRed(0);
                    currentPixel.setGreen(0);
                    currentPixel.setBlue(0);
                } else {
                    currentPixel.setRed(255);
                    currentPixel.setGreen(255);
                    currentPixel.setBlue(255);
                }
                image.setPixel(x, y, currentPixel);
            }
        }
        image.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {
        APImage image = new APImage(pathToFile);
        APImage reflectedImage = new APImage(image.getWidth(), image.getHeight());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel pixel = image.getPixel(x, y);
                reflectedImage.setPixel(image.getWidth() - 1 - x, y, pixel);
            }
        }
        reflectedImage.draw();
    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {
        APImage image = new APImage(pathToFile);
        APImage rotatedImage = new APImage(image.getHeight(), image.getWidth());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel pixel = image.getPixel(x, y);
                rotatedImage.setPixel(y, image.getWidth() - 1 - x, pixel);
            }
        }
        rotatedImage.draw();
    }
    }


