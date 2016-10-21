public class NameBuilder {

    private Name name;

    public NameBuilder() {
        this.name = new Name();
    }

    public NameBuilder addPrefix(String prefix) throws EmptyNameException {
        this.name.setPreFix(prefix);
        return this;
    }

    public NameBuilder addName(String name) throws EmptyNameException {
        this.name.addName(name);
        return this;
    }

    public NameBuilder addPostFix(String postfix) throws EmptyNameException {
        this.name.setPostFix(postfix);
        return this;
    }

    public Name getName() {
        return this.name;
    }

}
