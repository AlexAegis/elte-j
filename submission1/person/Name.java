package person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Name {

    private String preFix;
    private List<String> names;
    private String postFix;

    Name() {
        names = new ArrayList<>();
    }

    String getPreFix() {
        return preFix;
    }

    void setPreFix(String preFix) {
        this.preFix = preFix;
    }

    List<String> getNames() {
        return names;
    }

    void setNames(List<String> names) {
        this.names = names;
    }

    void addName(String name) {
        this.names.add(name);
    }

    String getPostFix() {
        return postFix;
    }

    void setPostFix(String postFix) {
        this.postFix = postFix;
    }

    @Override
    public String toString() {

        String result = "";

        if (this.getPreFix() != null) {
            result += this.getPreFix();
            if (this.getPostFix() != null || !this.getNames().isEmpty()) {
                result += " ";
            }
        }

        Iterator nameList = this.getNames().iterator();

        while(nameList.hasNext()) {
            result += nameList.next() + " ";
        }

        if (this.getPostFix() != null) {
            result += this.getPostFix();
        } else {
            result = result.substring(0, result.lastIndexOf(' '));
        }

        return result;
    }

}