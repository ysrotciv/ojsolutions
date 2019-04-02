package space.yangshuai.ojsolutions.codejam.roundonea;

/**
 * Created by rotciv on 2017/4/15.
 */
public class Ingredient implements Comparable {

    int value;
    float ratio;
    int min;
    int max;
    boolean valid = false;

    public Ingredient(int value, int standard) {
        this.value = value;
        this.ratio = value * 1.0f / standard;
        this.max = (int) Math.floor(value * 1.0 / 0.9 / standard);
        this.min = (int) Math.ceil(value * 1.0 / 1.1 / standard);
        if (min <= max) {
            this.valid = true;
        }
        if (min == 0 && max == 0) {
            this.valid = true;
        }
    }

    @Override
    public int compareTo(Object o) {
        return this.value - ((Ingredient)o).value;
    }
}
