package person;

import java.util.Arrays;

public class NameBuilder {

    private Name name;

    public NameBuilder() {
        this.name = new Name();
    }

    public NameBuilder(String names) {
        this();
        Arrays.asList(names.split(" ")).forEach(this::addName);
    }

    public NameBuilder addPrefix(String prefix) {
        if(prefix.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.name.setPreFix(prefix);
            return this;
        }
    }

    public NameBuilder addName(String name) {
        if(name.isEmpty() || Character.isLowerCase(name.charAt(0))) {
            throw new IllegalArgumentException();
        } else {
            this.name.addName(name);
            return this;
        }
    }

    public NameBuilder addPostFix(String postfix) {
        if(postfix.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.name.setPostFix(postfix);
            return this;
        }
    }

    public Name getName() {
        return this.name;
    }

}