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

final class Constants {
    // https://tr.wikipedia.org/w/index.php?title=B%C3%BCy%C3%BCk_say%C4%B1lar%C4%B1n_adlar%C4%B1&oldid=35841449
    public static final String[] SCALES = {
        null,
        "min", // 10^3
        "milyon", // 10^6
        "milyard", // 10^9
        "trilyon", // 10^12
        "katrilyon", // 10^15
        "kentilyon", // 10^18
        "sekstilyon", // 10^21
        "septilyon", // 10^24
        "oktilyon", // 10^27
        "nonilyon", // 10^30
        "desilyon", // 10^33
        "undesilyon", // 10^36
        "dodesilyon", // 10^39
        "tredesilyon", // 10^42
        "katordesilyon", // 10^45
        "kendesilyon", // 10^48
        "seksdesilyon", // 10^51
        "septendesilyon", // 10^54
        "oktodesilyon", // 10^57
        "novemdesilyon", // 10^60
        "vigintilyon", // 10^63
    };

    public static final String[] TENS = {
        null,
        "on",
        "iyirmi",
        "otuz",
        "qırx",
        "əlli",
        "altmış",
        "yetmiş",
        "səksən",
        "doxsan"
    };

    public static final String[] ONES = {
        "sıfır",
        "bir",
        "iki",
        "üç",
        "dörd",
        "beş",
        "altı",
        "yeddi",
        "səkkiz",
        "doqquz"
    };

    public static final int GROUP_SIZE = 3;

    public static final String HUNDRED = "yüz";

    public static final String SPACE = " ";

    private Constants() {}
}
