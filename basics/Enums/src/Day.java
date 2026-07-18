public enum Day {
    // 1. Define constants with their values in parentheses
    PI(3.14),
    G(9.8),
    SPEED_OF_LIGHT(299792458.0);

    // 2. Create a private field to store the value
    private final double value;

    // 3. Create an internal constructor (automatically called by Java)
    Day(double value) {
        this.value = value;
    }

    // 4. Create a getter method to read the value later
    public double getValue() {
        return this.value;
    }
}