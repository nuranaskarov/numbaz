/*
 * Copyright (c) 2025 Nuran Askarov <askar9v@gmail.com>
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nuranaskarov.numbaz;

import com.nuranaskarov.numbaz.exception.InvalidCharacterException;
import com.nuranaskarov.numbaz.exception.NumberTooLargeException;

import static com.nuranaskarov.numbaz.Constants.GROUP_SIZE;
import static com.nuranaskarov.numbaz.Constants.HUNDRED;
import static com.nuranaskarov.numbaz.Constants.ONES;
import static com.nuranaskarov.numbaz.Constants.SPACE;
import static com.nuranaskarov.numbaz.Constants.TENS;
import static com.nuranaskarov.numbaz.Constants.SCALES;

/**
 * Utility class for parsing and converting numeric digits to text representation.
 */
public class Numbaz {
    /** Maximum number of digits that can be processed. */
    public static int MAX_DIGITS = SCALES.length * GROUP_SIZE;

    /**
     * Parses a string of digits and converts it to text representation.
     *
     * @param digits the string containing numeric digits to parse
     * @return the text representation of the number
     * @throws NumberTooLargeException if the number of digits exceeds MAX_DIGITS
     * @throws InvalidCharacterException if the string contains invalid characters
     */
    public static String parse(String digits) {
        int digitsCount = digits.length();

        if (digitsCount > MAX_DIGITS) {
            throw new NumberTooLargeException(MAX_DIGITS);
        }

        StringBuilder output = new StringBuilder();
        boolean hasContent = false;

        int position = 0,
            scale = (digitsCount + GROUP_SIZE - 1) / GROUP_SIZE - 1,
            reminder = digitsCount % GROUP_SIZE;

        if (reminder > 0) {
            switch (reminder) {
                case 1:
                    hasContent = processGroup(0, 0, parseDigit(digits, 0), scale, output, hasContent);
                    break;
                case 2:
                    hasContent = processGroup(0, parseDigit(digits, 0), parseDigit(digits, 1), scale, output, hasContent);
                    break;
            }
            position = reminder;
            scale--;
        }

        while (position < digitsCount) {
            hasContent = processGroup(
                parseDigit(digits, position),
                parseDigit(digits, position + 1),
                parseDigit(digits, position + 2),
                scale,
                output,
                hasContent
            );
            position += GROUP_SIZE;
            scale--;
        }

        return hasContent ? output.toString() : ONES[0];
    }

    private static boolean processGroup(
        int hundred,
        int ten,
        int one,
        int scale,
        StringBuilder output,
        boolean hadContent
    ) {
        boolean hasContent = hadContent;

        if (hundred != 0) {
            if (hasContent) {
                output.append(SPACE);
            }
            if (hundred != 1) {
                output.append(ONES[hundred]);
                output.append(SPACE);
            }
            output.append(HUNDRED);
            hasContent = true;
        }

        if (ten != 0) {
            if (hasContent) {
                output.append(SPACE);
            }
            output.append(TENS[ten]);
            hasContent = true;
        }

        if (one != 0) {
            if (hasContent) {
                output.append(SPACE);
            }
            output.append(ONES[one]);
            hasContent = true;
        }

        if (scale != 0 && !(hundred + ten + one == 0)) {
            if (hasContent) {
                output.append(SPACE);
            }
            output.append(SCALES[scale]);
        }

        return hasContent;
    }

    private static int parseDigit(String digits, int index) {
        char character = digits.charAt(index);
        switch (character) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default:
                throw new InvalidCharacterException(character);
        }
    }

    private Numbaz() {}
}
