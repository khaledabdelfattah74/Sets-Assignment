package SetsClasses;

/**
 * Created by khaledabdelfattah on 9/20/17.
 */
public class Set {
    private static final int SIZE = 1000007;
    private static final int BASE = 31;
    private String set;
    private String[] hashTable = new String [SIZE], words;

    public Set (String set) {
        this.set = set;
        words = set.split(", ");
        proccesHashing();
    }

    public String[] getSetArr () {
        return words;
    }

    public String getSet () {
        return set;
    }

    private void proccesHashing () {
        for (String str : words) {
            int hashVal = hashFunction(str);
            if (hashTable[hashVal] == null)
                hashTable[hashVal] = str;
            else {
                int tmp = hashVal + 1;
                while (hashTable[(tmp ++) % SIZE] != null && tmp != hashVal);
                hashTable[tmp] = str;
            }
        }
    }

    private int hashFunction (String str) {
        int hashValue = 0;
        for (int i = 0; i < str.length(); i ++) {
            char z = str.charAt(i);
            hashValue = (hashValue * BASE + z) % SIZE;
        }
        return hashValue;
    }

    public boolean contian (String str) {
        int hashVal = hashFunction(str);
        if (hashTable[hashVal] != null)
            return true;
        else {
            int tmp = hashVal + 1;
            while (hashTable[(tmp ++) % SIZE] != null && tmp != hashVal) {
                if (str.equals(hashTable[tmp]))
                    return true;
            }
        }
        return false;
    }
}