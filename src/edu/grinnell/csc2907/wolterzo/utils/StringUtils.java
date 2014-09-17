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
    /* Go through the string character by character until you find the 
     * character to split the string at.*/
    for (int i = 0; i < str.length(); i++)
      {
        //find the splitting character
        if (str.charAt(i) == c)
          {
            /* put the substring in the array starting either from the beginning
             * of the string or from the index of the first character after the 
             * last 'c'.
             */
            array[aIndex] = str.substring(first, i);
            first = i + 1;
            aIndex++;
          } // if 
      } // for
    /* put the last substring in the array */
    array[aIndex] = str.substring(first);

    /*
     * Copy the non-null values of the array into the final array of the 
     * correct size.
     */
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
   * @return String[]
   */
  public static String[] splitCSV(String str)
  {
    String[] tempAr = new String[str.length()];
    int aIndex = 0;
    String currString = new String();
    char ch;
    boolean inQuote = false;
    /*
     * Go through the string character by character. 
     * - if in a quote
     *   - if you have two quotes add one then skip the next
     *   - else if you have a quote followed by a comma add the currString to the
     *     array, clear currString, and skip the comma
     *   - else add the character to the currString
     * - else if there's a comma, add currString to the array
     * - else if there's a quote, set inQuote to true
     * - else add the character to currString
     */
    for (int i = 0; i < str.length(); i++)
      {
        ch = str.charAt(i);
        if (inQuote)
          {
            if (ch == '\"' && (i + 1) < str.length()
                && str.charAt(i + 1) == '\"')
              {
                i++; //skip next quotation mark
                currString = currString + ch;
              } // if two quotes
            else if (ch == '\"' && (i + 1) < str.length()
                     && str.charAt(i + 1) == ',')
              {
                inQuote = false;
                tempAr[aIndex] = currString;
                aIndex++;
                currString = new String();
                i++;
              } // else if quote and comma
            else if (ch != '\"')
              {
                currString = currString + ch;
              } // else
          } // if inQuote
        else if (ch == ',')
          {
            tempAr[aIndex] = currString;
            aIndex++;
            currString = new String();
          } // if comma
        else if (ch == '\"')
          {
            inQuote = true;
          } // else if quotation
        else 
          {
            currString = currString + ch;
          } // else
      } // for
    /*
     * Transfer strings in tempAr to appropriately sized array.
     */
    tempAr[aIndex++] = currString;
    String[] array = new String[aIndex];
    for (int i = 0; i < array.length; i++)
      {
        array[i] = tempAr[i];
      } // for
    return array;
  } // splitCSV

  /**
   * Prints an array of strings. Used to experiment with results of methods.
   * @param array
   */
  public static void printArray(String[] array)
  {
    System.out.print("{ ");
    for (int i = 0; i < array.length - 1; i++)
      {
        System.out.print(array[i] + ". ");
      } // for
    System.out.print(array[array.length - 1] + " }\n");
  } // printArray
} // class StringUtils
