package championships.models;

import championships.competitions.Swimming;
import championships.results.ranking.Medals;


public class SwimmingMedals implements Medals {

    private Swimming results;
    private String nation;

    public SwimmingMedals(Swimming results, String nation) {
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

        SwimmingMedals swimmingMedals = (SwimmingMedals) o;

        return getGolds() == swimmingMedals.getGolds() && getSilvers() == swimmingMedals.getSilvers() && getBronzes() == swimmingMedals.getBronzes();
    }

    @Override
    public int hashCode() {
        return getGolds() * 222 + getSilvers() * 33 + getBronzes() * 4;
    }

    @Override
    public int compareTo(Medals obj) {
        return ((getGolds() - obj.getGolds()) * 100)
                + ((getSilvers() - obj.getSilvers()) * 10)
                - (getBronzes() - obj.getBronzes());
    }

    @Override
    public String toString() {
        return "<" + getGolds() + ", " + getSilvers() + ", " + getBronzes() + ">";
    }
}