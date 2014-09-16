package edu.grinnell.csc2907.wolterzo.utils;

public class StringUtils
{
  /**
   * splitAt returns an array of strings that are substrings of str split at char c
   * @param str
   * @param c
   * @return String[]
   */
  public static String[] splitAt(String str, char c)
  {
    String[] array = new String[str.length()];
    int aIndex = 0;
    int first = 0;
    for (int i = 0; i < str.length(); i++)
      {
        if (str.charAt(i) == c)
          {
            array[aIndex] = str.substring(first, i);
            first = i + 1;
            aIndex++;
          } // if 
      } // for
    array[aIndex] = str.substring(first);

    String[] finalArray = new String[aIndex + 1];
    for (int i = 0; i < finalArray.length; i++)
      {
        finalArray[i] = array[i];
      } // for
    return finalArray;
  } // splitAt(String, char)

  /**
   * splitCSV returns an array of substrings of str separated by commas and 
   * grouped by quotation marks
   * @param str
   * @return
   * 
   * NOT WORKING
   * - adding what's after the separator or before, stick to one method. 
   */
  public static String[] splitCSV(String str)
  {
    String[] tempAr = new String[str.length()];
    int aIndex = 0;

    for (int i = 0; i < str.length(); i++)
      {
        System.out.println("at char: " + str.charAt(i));
        if (str.charAt(i) == ',' && str.charAt(i + 1) == '\"')
          {
            int j;
            for (j = i; j < str.length(); j++)
              {
                if (str.charAt(j) == '\"'
                    && (str.charAt(j + 1) == ',' || str.length() == j + 1))
                  {
                    tempAr[aIndex] = str.substring(i + 2, j);
                    System.out.println(tempAr[aIndex]);
                    aIndex++;
                    break;
                  } // if 
              } // for
            i = j;
          } // if 
        else if (str.charAt(i) == ',')
          {
            // last element
            if (str.indexOf(',', i + 1) == -1)
              {
                tempAr[aIndex] = str.substring(i + 1);
                System.out.println(tempAr[aIndex]);
                aIndex++;
              } // else if
            else
              {
                tempAr[aIndex] = str.substring(i + 1, str.indexOf(',', i + 1));
                System.out.println(tempAr[aIndex]);
                i = str.indexOf(',', i + 1) - 1;
                aIndex++;
              }
          } // else if
        else
          {
            // if the first element in the array
            if (aIndex == 0)
              {
                tempAr[aIndex] = str.substring(0, str.indexOf(','));
                System.out.println(tempAr[aIndex]);
                i = str.indexOf(',', 0) - 1;
                aIndex++;
              } // if
          } // else
      } // for
    String[] array = new String[aIndex];
    for (int i = 0; i < array.length; i++)
      {
        array[i] = tempAr[i];
      } // for
    return array;
  }

  /**
   * Prints an array of strings
   * @param array
   */
  public static void printArray(String[] array)
  {
    System.out.print("{ ");
    for (int i = 0; i < array.length - 1; i++)
      {
        System.out.print(array[i] + ". ");
      }
    System.out.print(array[array.length - 1] + " }\n");
  }
}
