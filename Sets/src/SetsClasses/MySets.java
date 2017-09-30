package SetsClasses;

/**
 * Created by khaledabdelfattah on 9/21/17.
 */
public class MySets {
    private Set setA, setB;
    private StringBuilder result;

    public MySets (Set setA, Set setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public String setsUnion () {
        result = new StringBuilder();
        result.append('{' + setA.getSet() + ", ");
        for (String str : setB.getSetArr())
            if (!setA.contian(str))
                result.append(str + ", ");
        if (result.length() > 2)
            deleteCharAt();
        result.append("}");
        return result.toString();
    }

    public String setsIntersection () {
        result = new StringBuilder();
        result.append("{");
        for (String str : setA.getSetArr())
            if (setB.contian(str))
                result.append(str + ", ");
        if (result.length() > 2)
            deleteCharAt();
        result.append("}");
        return result.toString();
    }

    public String setComplement () {
        result = new StringBuilder();
        result.append("{");
        for (String str : setA.getSetArr())
            if (!setB.contian(str))
                result.append(str + ", ");
        if (result.length() > 2)
            deleteCharAt();
        result.append("}");
        return result.toString();
    }

    private void deleteCharAt () {
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
    }
}