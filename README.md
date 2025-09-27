# Numbaz

Numbaz is a Java library that converts a numeric string 
that represents a whole natural number 
into their written Azerbaijani equivalents.

No external dependencies.

## Examples

```java
Numbaz.parse("0"); // sıfır
Numbaz.parse("1"); // bir
Numbaz.parse("25"); // iyirmi beş
Numbaz.parse("100"); // yüz
Numbaz.parse("778"); // yeddi yüz yetmiş səkkiz
Numbaz.parse("11000"); // on bir min
Numbaz.parse("11111"); // on bir min yüz on bir
Numbaz.parse("300300"); // üç yüz min üç yüz
Numbaz.parse("9876543"); // doqquz milyon səkkiz yüz yetmiş altı min beş yüz qırx üç
Numbaz.parse("2147483647"); // iki milyard yüz qırx yeddi milyon dörd yüz səksən üç min altı yüz qırx yeddi
Numbaz.parse("1000000000000"); // bir trilyon
Numbaz.parse("6847392658174639"); // altı katrilyon səkkiz yüz qırx yeddi trilyon üç yüz doxsan iki milyard altı yüz əlli səkkiz milyon yüz yetmiş dörd min altı yüz otuz doqquz
Numbaz.parse("493882371553121860890561055192142938414552660618128252927700430053"); // dörd yüz doxsan üç vigintilyon səkkiz yüz səksən iki novemdesilyon üç yüz yetmiş bir oktodesilyon beş yüz əlli üç septendesilyon yüz iyirmi bir seksdesilyon səkkiz yüz altmış kendesilyon səkkiz yüz doxsan katordesilyon beş yüz altmış bir tredesilyon əlli beş dodesilyon yüz doxsan iki undesilyon yüz qırx iki desilyon doqquz yüz otuz səkkiz nonilyon dörd yüz on dörd oktilyon beş yüz əlli iki septilyon altı yüz altmış sekstilyon altı yüz on səkkiz kentilyon yüz iyirmi səkkiz katrilyon iki yüz əlli iki trilyon doqquz yüz iyirmi yeddi milyard yeddi yüz milyon dörd yüz otuz min əlli üç

Numbaz.parse("1 50"); 
// throws InvalidCharacterException
Numbaz.parse("1".repeat(1000)); 
// throws NumberTooLargeException 
```

## Installation

Gradle
```java
implementation 'com.nuranaskarov:numbaz:0.1.1'
```
Maven
```xml
<dependency>
    <groupId>com.nuranaskarov</groupId>
    <artifactId>numbaz</artifactId>
    <version>0.1.1</version>
</dependency>
```

## Numbers

Numbaz supports numbers up to vigintilyon which is 10^63. 

The input is limited by MAX_DIGITS constant.

The scale names are taken from the [Wikipedia page – Büyük sayıların adları](https://tr.wikipedia.org/w/index.php?title=B%C3%BCy%C3%BCk_say%C4%B1lar%C4%B1n_adlar%C4%B1&oldid=35841449).

| Scale | Name (az)      | Name (en)         |
| ----- |----------------|-------------------|
| 10⁰   | bir            | one               |
| 10³   | min            | thousand          |
| 10⁶   | milyon         | million           |
| 10⁹   | milyard        | billion           |
| 10¹²  | trilyon        | trillion          |
| 10¹⁵  | katrilyon      | quadrillion       |
| 10¹⁸  | kentilyon      | quintillion       |
| 10²¹  | sekstilyon     | sextillion        |
| 10²⁴  | septilyon      | septillion        |
| 10²⁷  | oktilyon       | octillion         |
| 10³⁰  | nonilyon       | nonillion         |
| 10³³  | desilyon       | decillion         |
| 10³⁶  | undesilyon     | undecillion       |
| 10³⁹  | dodesilyon     | duodecillion      |
| 10⁴²  | tredesilyon    | tredecillion      |
| 10⁴⁵  | katordesilyon  | quattuordecillion |
| 10⁴⁸  | kendesilyon    | quindecillion     |
| 10⁵¹  | seksdesilyon   | sexdecillion      |
| 10⁵⁴  | septendesilyon | septendecillion   |
| 10⁵⁷  | oktodesilyon   | octodecillion     |
| 10⁶⁰  | novemdesilyon  | novemdecillion    |
| 10⁶³  | vigintilyon    | vigintillion      |

## Contributions

Anyone is welcome to extend or improve this library.

## License

This project is licensed under the MIT License.