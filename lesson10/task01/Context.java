class Context {
    private final BinaryIntFunction bif;

    public Context(BinaryIntFunction bif) {
        this.bif = bif;
    }

    public int compute(int x, int y) {
        return this.bif.apply(x, y);
    }
}
