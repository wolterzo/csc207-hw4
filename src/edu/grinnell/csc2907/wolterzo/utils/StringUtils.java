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
    String currString = new String();
    char ch;
    boolean inQuote = false;

    for (int i = 0; i < str.length(); i++)
      {
        ch = str.charAt(i);
        if (inQuote)
          {
            System.out.println("In quote");
            if (ch == '\"' && (i + 1) < str.length()
                && str.charAt(i + 1) == '\"')
              {
                System.out.println("skipped a quote");
                i++; //skip next quotation mark
                currString = currString + ch;
              }
            else if (ch == '\"' && (i + 1) < str.length()
                     && str.charAt(i + 1) == ',')
              {
                inQuote = false;
                tempAr[aIndex] = currString;
                System.out.println("add quoted string: " + currString);
                aIndex++;
                currString = new String();
                i++;
              }
            else
              {
                currString = currString + ch;
                System.out.println(currString);
              }
          } // if inQuote
        else if (ch == ',')
          {
            tempAr[aIndex] = currString;
            System.out.println("add string: " + currString);
            aIndex++;
            currString = new String();
          }// if comma
        else if (ch == '\"')
          {
            inQuote = true;
            System.out.println("inquote");
          } // else if quotation
        else
          {
            currString = currString + ch;
            System.out.println(currString);
          }
      } // for
    tempAr[aIndex++] = currString;
    System.out.println("add end string: " + currString);
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
