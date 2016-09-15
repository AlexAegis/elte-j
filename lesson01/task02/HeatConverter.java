class HeatConverter {

    private int value;
    private String type;

    private HeatConverter() {

    }

    public HeatConverter(int value) {
        this.value = value;
    }

    public HeatConverter setHeatType(String type) {
        this.type = type.toUpperCase();
        return this;
    }

    public int getAsCelsius() throws WrongHeatTypeException {
        if (this.type.equals("C")) {
            return this.value;
        } else if (this.type.equals("F")) {
            return ((this.value - 32) * 5) / 9;
        }
        throw new WrongHeatTypeException();
    }

    public int getAsFahrenheit() throws WrongHeatTypeException {
        if (this.type.equals("F")) {
            return this.value;
        } else if (this.type.equals("C")) {
            return ((this.value * 9) / 5) + 32;
        }
        throw new WrongHeatTypeException();
    }

    public int getAsOther() throws WrongHeatTypeException {
        if (this.type.equals("F")) {
            return getAsCelsius();
        } else if (this.type.equals("C")) {
            return getAsFahrenheit();
        }
        throw new WrongHeatTypeException();
    }
}
