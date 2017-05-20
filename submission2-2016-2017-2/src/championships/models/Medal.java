package championships.models;

import championships.competitions.Swimming;
import championships.results.ranking.Medals;


public class Medal implements Medals {

    private Swimming results;
    private String nation;

    public Medal(Swimming results, String nation) {
        this.results = results;
        this.nation = nation;
    }

    @Override
    public int getGolds() {
        return (int) results.getResultsByNation(nation).stream()
                .filter(result -> result.getScore() == 1).count();
    }

    @Override
    public int getSilvers() {
        return (int) results.getResultsByNation(nation).stream()
                .filter(result -> result.getScore() == 2).count();
    }

    @Override
    public int getBronzes() {
        return (int) results.getResultsByNation(nation).stream()
                .filter(result -> result.getScore() == 3).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medal medal = (Medal) o;

        return getGolds() == medal.getGolds() && getSilvers() == medal.getSilvers() && getBronzes() == medal.getBronzes();
    }

    @Override
    public int hashCode() {
        return getGolds() * 222 + getSilvers() * 33 + getBronzes() * 4;
    }

    @Override
    public int compareTo(Medals obj) {
        return ((getGolds() - obj.getGolds()) * 100)
                + ((getSilvers() - obj.getSilvers()) * 10)
                - ((getBronzes() - obj.getBronzes()) * 1);
    }

    @Override
    public String toString() {
        return "<" + getGolds() + ", " + getSilvers() + ", " + getBronzes() + ">";
    }
}