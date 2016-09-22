public class NameBuilder {

    private Name name;

    public NameBuilder() {
        this.name = new Name();
    }

    public NameBuilder addPrefix(String prefix) {
        this.name.setPreFix(prefix);
        return this;
    }

    public NameBuilder addName(String name) {
        this.name.addName(name);
        return this;
    }

    public NameBuilder addPostFix(String postfix) {
        this.name.setPostFix(postfix);
        return this;
    }

    public Name getName() {
        return this.name;
    }

}
