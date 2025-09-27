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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbazTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/0-9.csv")
    void shouldParseFrom0to9(String input, String expected) {
        test(input, expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/10-99.csv")
    void shouldParseFrom10to99(String input, String expected) {
        test(input, expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/100-999.csv")
    void shouldParseFrom100to999(String input, String expected) {
        test(input, expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/1000-and-more.csv")
    void shouldParseFrom1000andMore(String input, String expected) {
        test(input, expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/zeros.csv")
    void shouldParseZeros(String input, String expected) {
        test(input, expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/big-numbers.csv")
    void shouldParseBigNumbers(String input, String expected) {
        test(input, expected);
    }

    @Test
    void shouldThrowExceptionWhenInvalidDigits() {
        assertThatThrownBy(() -> Numbaz.parse("1+1"))
            .isInstanceOf(InvalidCharacterException.class);
    }

    @Test
    void shouldThrowExceptionWhenTooLargeInput() {
        assertThatThrownBy(() -> Numbaz.parse("1" + "493882371553121860890561055192142938414552660618128252927700430053"))
            .isInstanceOf(NumberTooLargeException.class);
    }

    private void test(String input, String expected) {
        String actual = Numbaz.parse(input);
        assertThat(actual)
            .describedAs(input)
            .isEqualTo(expected);
    }
}