import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RoyalRumble {
  public List<String> getSortedList(List<String> names) {
    List<NameRoman> nameList = new ArrayList<>(names.size());
    for(String name: names) {
      String[] nameParts = name.split(" ");
      NameRoman newName = new NameRoman(nameParts);
      nameList.add(newName);
    }
    nameList.sort(null);

    List<String> sortedNames = new ArrayList<String>();
    for(NameRoman i: nameList) {
      sortedNames.add(i.toString());
    }

    return sortedNames;
  }
}

class NameRoman implements Comparable<NameRoman> {
  Map<Character, Integer> romanMap;

  private String firstName;
  private String romanNumeralString;
  private Integer romanNumeral;

  public NameRoman(String[] parts) {
    romanMap = new HashMap<>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    this.firstName = parts[0];
    this.romanNumeralString = parts[1];
    this.romanNumeral = _parseRomanNumeral(this.romanNumeralString);
  }

  private int _parseRomanNumeral(String input) {
    int val = 0;

    for(int idx=0; idx<input.length()-1; idx++) {
      int currVal = romanMap.get(input.charAt(idx));
      int nextVal = romanMap.get(input.charAt(idx + 1));

      if(currVal < nextVal ) {
        val = nextVal - val;
      } else if(currVal == nextVal) {
        val += currVal;
      }
    }

    return val;
  }

  public int compareTo(NameRoman other) {
    if(this.firstName == other.firstName) {
      return this.romanNumeral - other.romanNumeral;
    }
    return this.firstName.compareTo(other.firstName);
  }

  public String toString() {
    return this.firstName + " " + this.romanNumeralString;
  }

}